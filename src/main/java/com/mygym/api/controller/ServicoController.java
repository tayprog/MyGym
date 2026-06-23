package com.mygym.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mygym.api.model.Servico;
import com.mygym.api.repositories.ServicoRepository;

@RestController
@RequestMapping("/api/servicos")
@CrossOrigin("*")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @GetMapping
    public List<Servico> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Servico salvar(@RequestBody Servico servico) {
        return repository.save(servico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}