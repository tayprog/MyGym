package com.mygym.api.dto;

public record ContatoDTO(
    Long id, 
    String nome, 
    String email, 
    String telefone, 
    String assunto, 
    String mensagem
) {

}