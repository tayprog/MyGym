package com.mygym.api.controller;

import com.mygym.api.model.ContatoForm;
import com.mygym.api.service.MyGymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/contato")
@CrossOrigin("*") // Permite que o seu HTML converse com o Java sem dar erro de CORS
public class ContatoController {

    @Autowired
    private MyGymService myGymService;

    @PostMapping
    public ResponseEntity<Map<String, String>> receberContato(@RequestBody ContatoForm form) {
        try {
            myGymService.processarContato(form);
            // Retorna um JSON idêntico ao que o seu script.js espera no "resultado.mensagem"
            return ResponseEntity.ok(Map.of("mensagem", "Mensagem enviada com sucesso! ✅"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("erro", "Erro ao salvar mensagem no servidor."));
        }
    }
}