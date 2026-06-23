package com.mygym.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mygym.api.model.SolicitacaoMatricula;

public interface SolicitacaoRepository extends JpaRepository<SolicitacaoMatricula, Long> {}