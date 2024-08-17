package com.ronaldosantos.projetomaven.recursosweb.excecoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ronaldosantos.projetomaven.servicos.excecoes.AcessoDeDadosExcecao;
import com.ronaldosantos.projetomaven.servicos.excecoes.RecursoNaoEcontradoExcecao;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TratarExcecoes {
	
	@ExceptionHandler(RecursoNaoEcontradoExcecao.class)
	public ResponseEntity<ErroPadrao> recursoNaoEcontrado(RecursoNaoEcontradoExcecao e,HttpServletRequest request){
		String error = "Recurso não econtrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(AcessoDeDadosExcecao.class)
	public ResponseEntity<ErroPadrao> recursoNaoEcontrado(AcessoDeDadosExcecao e,HttpServletRequest request){
		String error = "Recurso não econtrado";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao err = new ErroPadrao(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
