package br.com.fiap.sprint1.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RequestException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> tratar404() {
        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", "Nada encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta); // 404
    }
}

