package br.com.joao.trabalho.Repository.controller;


import br.com.joao.trabalho.Model.ContaPagar;
import br.com.joao.trabalho.Repository.ContaPagarRepository;
import br.com.joao.trabalho.Repository.filter.ContaPagarFilter;
import br.com.joao.trabalho.Repository.projections.ResumoConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contapagar")
public class ContaPagarController {

   @Autowired
   private ContaPagarRepository contaPagarRepository;

   @GetMapping("/todos")
    public List<ContaPagar> listarTodasContas(){
       return contaPagarRepository.findAll();
   }

   @GetMapping()
    public Page<ResumoConta> pesquisar(ContaPagarFilter contaPagarFilter, Pageable pageable){
       return contaPagarRepository.filtrar(contaPagarFilter, pageable);
   }

}
