package br.com.joao.trabalho.Repository.contaPagar;

import br.com.joao.trabalho.Model.ContaPagar;
import br.com.joao.trabalho.Repository.filter.ContaPagarFilter;
import br.com.joao.trabalho.Repository.projections.ResumoConta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ContaPagarRepositoryImpl implements ContaPagarRepositoryQuery{

        @PersistenceContext
        private EntityManager manager;


        @Override
        public Page<ResumoConta> filtrar(ContaPagarFilter contaPagarFilter, Pageable pageable) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<ResumoConta> criteria = builder.createQuery(ResumoConta.class);
            Root<ContaPagar> root = criteria.from(ContaPagar.class);

            criteria.select(builder.construct(ResumoConta.class,
                    root.get("id"),
                    root.get("data"),
                    root.get("datavencimento"),
                    root.get("valor"),
                    root.get("cliente").get("nomecliente")));

            Predicate[] predicates = criarrestricoes(contaPagarFilter, builder, root);
            criteria.where(predicates);
            criteria.orderBy(builder.asc(root.get("data")));

            TypedQuery<ResumoConta> query = manager.createQuery(criteria);
            adicionarRestricoesDePaginacao(query, pageable);

            return new PageImpl(query.getResultList(), pageable, total(contaPagarFilter));
        }

        private Long total(ContaPagarFilter contaPagarFilter){
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
            Root<ContaPagar> root = criteria.from(ContaPagar.class);

            Predicate[] predicates = criarrestricoes(contaPagarFilter, builder, root);
            criteria.where(predicates);
            criteria.orderBy(builder.asc(root.get("data")));

            criteria.select(builder.count(root));

            return manager.createQuery(criteria).getSingleResult();
        }

        private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
            int paginaAtual = pageable.getPageNumber();
            int totalRegistrosPorPagina = pageable.getPageSize();
            int primeiroRegistroPagina = paginaAtual * totalRegistrosPorPagina;

            query.setFirstResult(primeiroRegistroPagina);
            query.setMaxResults(totalRegistrosPorPagina);
        }

        private Predicate[] criarrestricoes(ContaPagarFilter contaPagarFilter, CriteriaBuilder builder, Root<ContaPagar> root){
            List<Predicate> predicates = new ArrayList<>();

            if(contaPagarFilter.getData() != null){

                predicates.add(builder.greaterThanOrEqualTo(root.get("data"),
                        contaPagarFilter.getData()));

            }
            if(contaPagarFilter.getData() != null){

                predicates.add(builder.lessThanOrEqualTo(root.get("data"),
                        contaPagarFilter.getData()));

            }

            if(contaPagarFilter.getData() != null){

                predicates.add(builder.greaterThanOrEqualTo(root.get("datavencimento"),
                        contaPagarFilter.getDatavencimento()));

            }
            if(contaPagarFilter.getData() != null) {

                predicates.add(builder.lessThanOrEqualTo(root.get("datavencimento"),
                        contaPagarFilter.getDatavencimento()));
            }
            if (contaPagarFilter.getValor() != null){
                predicates.add(builder.equal(root.get("valor"),
                        contaPagarFilter.getValor()));
            }
            if (!StringUtils.isEmpty(contaPagarFilter.getNomecliente())){
                predicates.add(builder.like(builder.lower(root.get("cliente").get("nomecliente")),
                        "%" + contaPagarFilter.getNomecliente() + "%"));
            }
            return predicates.toArray(new Predicate[predicates.size()]);
        }
}

