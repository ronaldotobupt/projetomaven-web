package com.ronaldosantos.projetomaven.recursosweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldosantos.projetomaven.entidades.Produto;
import com.ronaldosantos.projetomaven.servicos.ServicoProduto;

@RestController
@RequestMapping(value = "/produto")
public class RecursoWebProduto {
	
	@Autowired
	private ServicoProduto servico;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> listadecategorias(){
		List<Produto> listaprodutos = servico.todosProdutos();
		return ResponseEntity.ok().body(listaprodutos);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscaProdutoPorId(@PathVariable Long id){
		Produto obj = servico.produtoPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
