package com.ronaldosantos.projetomaven.recursosweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldosantos.projetomaven.entidades.Pedido;
import com.ronaldosantos.projetomaven.servicos.ServicoPedido;

@RestController
@RequestMapping(value = "/pedido")
public class RecursoWebPedido {
	
	@Autowired
	private ServicoPedido servico;
	
	
	@GetMapping
	public ResponseEntity<List<Pedido>> listadepedidos(){
		List<Pedido> listapedidos = servico.todosPedidos();
		return ResponseEntity.ok().body(listapedidos);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscaPedidoPorId(@PathVariable Long id){
		Pedido obj = servico.PedidoPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
