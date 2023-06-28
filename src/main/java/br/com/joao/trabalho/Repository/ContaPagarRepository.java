package br.com.joao.trabalho.Repository;

import br.com.joao.trabalho.Model.ContaPagar;
import br.com.joao.trabalho.Repository.contaPagar.ContaPagarRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPagarRepository extends JpaRepository<ContaPagar, Integer>, ContaPagarRepositoryQuery {
}
