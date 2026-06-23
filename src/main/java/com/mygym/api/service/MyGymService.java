package com.mygym.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygym.api.model.*;
import com.mygym.api.repositories.*;


@Service // Registra a classe como um serviço do Spring
public class MyGymService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private ContatoRepository contatoRepository; // Restaurado para evitar erro com os imports

    // Método para listagem de serviços adicionais
    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    // Método para listagem de planos
    public List<Plano> listarPlanos() {
        return planoRepository.findAll();
    }

    // Método para processar e salvar os formulários de contato/leads do front-end
    public void processarContato(ContatoForm form) {
        contatoRepository.save(form);
    }
}