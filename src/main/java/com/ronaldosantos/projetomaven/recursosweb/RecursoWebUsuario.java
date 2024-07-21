package com.ronaldosantos.projetomaven.recursosweb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldosantos.projetomaven.entidades.Usuario;

@RestController
@RequestMapping(value ="/usuarios")
public class RecursoWebUsuario {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario(1L, "Maria", "maria@gmail.com", "999991111", "123456");
		return ResponseEntity.ok().body(u);
	}

}
