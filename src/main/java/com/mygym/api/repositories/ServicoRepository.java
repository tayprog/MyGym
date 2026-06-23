package com.mygym.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mygym.api.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {}