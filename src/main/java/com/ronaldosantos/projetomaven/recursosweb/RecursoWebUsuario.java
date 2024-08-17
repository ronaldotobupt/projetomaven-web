package com.ronaldosantos.projetomaven.recursosweb;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario obj){
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> delete (@PathVariable Long id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
