package com.mygym.api.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SolicitacaoMatricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String plano;
    private String horario;
    
    @Column(columnDefinition = "TEXT")
    private String modalidadesExtras; // Salvo como string formatada para simplificar
    private String observacao;
    private String status = "Pendente";
    private LocalDate data = LocalDate.now();
}