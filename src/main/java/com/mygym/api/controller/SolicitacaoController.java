package com.mygym.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mygym.api.model.SolicitacaoMatricula;
import com.mygym.api.repositories.SolicitacaoRepository;

@RestController
@RequestMapping("/api/solicitacoes")
@CrossOrigin("*")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoRepository repository;

    @GetMapping
    public List<SolicitacaoMatricula> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public SolicitacaoMatricula criar(@RequestBody SolicitacaoMatricula solicitacao) {
        return repository.save(solicitacao);
    }

    @PutMapping("/{id}/status")
    public SolicitacaoMatricula alterarStatus(@PathVariable Long id) {
        SolicitacaoMatricula sol = repository.findById(id).orElseThrow();
        if (sol.getStatus().equals("Pendente")) sol.setStatus("Contatado");
        else if (sol.getStatus().equals("Contatado")) sol.setStatus("Matriculado");
        return repository.save(sol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}