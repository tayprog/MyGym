package com.mygym.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Data;

@Entity 
@Data   
public class ContatoForm {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; 
    
    private String email; 

    private String telefone; 
    private String assunto; 

    @Column(columnDefinition = "TEXT")
    private String mensagem; 
}