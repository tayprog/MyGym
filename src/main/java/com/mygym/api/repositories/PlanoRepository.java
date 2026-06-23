package com.mygym.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mygym.api.model.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long> {}
