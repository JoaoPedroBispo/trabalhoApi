package br.com.joao.trabalho.Repository.controller;


import br.com.joao.trabalho.Model.Cliente;
import br.com.joao.trabalho.Repository.ClienteRepository;
import br.com.joao.trabalho.Repository.filter.ClienteFilter;
import br.com.joao.trabalho.Repository.projections.ResumoConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/todos")
    public List<Cliente> listarTodosCliente(){
        return clienteRepository.findAll();
    }

    @GetMapping()
    public Page<Cliente> pesquisar(ClienteFilter clienteFilter, Pageable pageable){
       return clienteRepository.filtrar(clienteFilter, pageable);
    }

}
