package com.mygym.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mygym.api.model.ContatoForm;

public interface  ContatoRepository extends JpaRepository<ContatoForm, Long> {
    
}
