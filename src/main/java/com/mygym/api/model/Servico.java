package com.mygym.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @Column(columnDefinition = "TEXT") // Para suportar strings Base64 longas de imagem
    private String imagem;
    private String icone;
    private Double preco;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
}