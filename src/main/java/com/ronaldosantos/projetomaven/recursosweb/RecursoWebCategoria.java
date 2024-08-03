package com.ronaldosantos.projetomaven.recursosweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldosantos.projetomaven.entidades.Categoria;
import com.ronaldosantos.projetomaven.servicos.ServicoCategoria;

@RestController
@RequestMapping(value = "/categoria")
public class RecursoWebCategoria {
	
	@Autowired
	private ServicoCategoria servico;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listadecategorias(){
		List<Categoria> listacategorias = servico.todosCategorias();
		return ResponseEntity.ok().body(listacategorias);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscaCategoriaPorId(@PathVariable Long id){
		Categoria obj = servico.categoriaPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
