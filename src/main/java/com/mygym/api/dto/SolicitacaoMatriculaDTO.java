package com.mygym.api.dto;

import java.time.LocalDate;

public record SolicitacaoMatriculaDTO(
    Long id, 
    String nome, 
    String telefone, 
    String email, 
    String plano, 
    String horario, 
    String modalidadesExtras, 
    String observacao,
    String status, 
    LocalDate data
) {
    
    // Construtor secundário: permite criar a DTO passando apenas os dados essenciais
    // O status e a data são preenchidos automaticamente se não forem informados.
    public SolicitacaoMatriculaDTO(
        Long id, String nome, String telefone, String email, String plano, 
        String horario, String modalidadesExtras, String observacao
    ) {
        this(id, nome, telefone, email, plano, horario, modalidadesExtras, observacao, "Pendente", LocalDate.now());
    }
}