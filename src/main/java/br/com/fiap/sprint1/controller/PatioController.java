package br.com.fiap.sprint1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.sprint1.dto.PatioDTO;
import br.com.fiap.sprint1.entity.Patio;
import br.com.fiap.sprint1.repository.PatioRepository;
import br.com.fiap.sprint1.service.PatioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/patios")
@SuppressWarnings("all")
public class PatioController {

    @Autowired
    private PatioService patioService;  
    
    
    @GetMapping
    public ResponseEntity listarPatios() {
        var allPatios = patioService.listarPatios();  
        return ResponseEntity.ok(allPatios);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity buscarPatioPorId(@PathVariable Integer id) {
        Patio patio = patioService.buscarPatioPorId(id); 
        if (patio != null) {
            return ResponseEntity.ok(patio);
        } else {
        	throw new EntityNotFoundException(); //se nao encontrar dados, lança a excecao que sera capturada pela classe de exception
        }
    }

    
    @PostMapping
    public ResponseEntity criarPatio(@RequestBody @Valid PatioDTO data) {
        Patio patio = patioService.criarPatio(data);  
        return ResponseEntity.status(201).body(patio); // 201 -> Patio criado
    }

    
    @PutMapping("/{id}")
    public ResponseEntity atualizarPatio(@PathVariable Integer id, @RequestBody @Valid PatioDTO data) {
        Patio patio = patioService.atualizarPatio(id, data); 
        if (patio != null) {
            return ResponseEntity.ok(patio);
        } else {
        	throw new EntityNotFoundException();
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletarPatio(@PathVariable Integer id) {
        boolean deleted = patioService.deletarPatio(id);  
        Map<String, String> resposta = new HashMap<>();

        if (deleted) {
            resposta.put("mensagem", "Pátio com ID " + id + " deletado com sucesso.");
            return ResponseEntity.ok(resposta);
        } else {
            throw new EntityNotFoundException();
        }
    }

}
