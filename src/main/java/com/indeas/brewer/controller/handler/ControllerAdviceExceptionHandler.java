package com.indeas.brewer.controller.handler;

import com.indeas.brewer.exception.NomeEstiloJaCadastradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(NomeEstiloJaCadastradoException.class)
	public ResponseEntity<String> handleNomeEstiloJaCadastradoException(NomeEstiloJaCadastradoException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
}
