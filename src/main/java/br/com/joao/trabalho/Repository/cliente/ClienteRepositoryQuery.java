package br.com.joao.trabalho.Repository.cliente;

import br.com.joao.trabalho.Model.Cliente;
import br.com.joao.trabalho.Repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}