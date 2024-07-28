package com.ronaldosantos.projetomaven.recursosweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldosantos.projetomaven.entidades.Usuario;
import com.ronaldosantos.projetomaven.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuario")
public class RecursoWebUsuario {
	
	@Autowired
	private ServicoUsuario servico;
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listadeusuarios(){
		List<Usuario> listausuarios = servico.todosUsuarios();
		return ResponseEntity.ok().body(listausuarios);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscaUsuarioPorId(@PathVariable Long id){
		Usuario obj = servico.usuarioPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
