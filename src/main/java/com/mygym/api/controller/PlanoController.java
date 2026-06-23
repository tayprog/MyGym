package com.mygym.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mygym.api.model.Plano;
import com.mygym.api.repositories.PlanoRepository;

@RestController
@RequestMapping("/api/planos")
@CrossOrigin("*")
public class PlanoController {

    @Autowired
    private PlanoRepository repository;

    @GetMapping
    public List<Plano> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Plano atualizar(@RequestBody Plano plano) {
        return repository.save(plano); // No JPA, save() atualiza se o ID já existir
    }
}