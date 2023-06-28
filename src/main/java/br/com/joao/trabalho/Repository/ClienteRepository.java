package br.com.joao.trabalho.Repository;

import br.com.joao.trabalho.Model.Cliente;
import br.com.joao.trabalho.Repository.cliente.ClienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, ClienteRepositoryQuery {
}
