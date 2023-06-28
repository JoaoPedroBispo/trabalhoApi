package br.com.joao.trabalho.Repository.contaPagar;

import br.com.joao.trabalho.Model.ContaPagar;
import br.com.joao.trabalho.Repository.filter.ContaPagarFilter;
import br.com.joao.trabalho.Repository.projections.ResumoConta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContaPagarRepositoryQuery {
     Page<ResumoConta> filtrar(ContaPagarFilter contaPagarFilter, Pageable pageable);
}
