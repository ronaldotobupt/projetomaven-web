package com.ronaldosantos.projetomaven.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldosantos.projetomaven.entidades.Pedido;
import com.ronaldosantos.projetomaven.repositorios.RepositorioPedido;

@Service
public class ServicoPedido {
	
	@Autowired
	private RepositorioPedido repositorio;
	
	public List<Pedido> todosPedidos(){
		return repositorio.findAll();
	}
	
	public Pedido PedidoPorId(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}

}
