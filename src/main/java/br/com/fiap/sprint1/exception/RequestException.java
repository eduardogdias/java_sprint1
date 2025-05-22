package br.com.fiap.sprint1.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
@SuppressWarnings("all")
public class RequestException {

	// quando a API retornar 404, vai mostrar a mensagem que está nesse método
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity threat404() {
		return ResponseEntity.badRequest().body("Dado não encontrado");
	}
}
