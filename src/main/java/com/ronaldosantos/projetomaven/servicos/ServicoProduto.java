package com.ronaldosantos.projetomaven.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldosantos.projetomaven.entidades.Produto;
import com.ronaldosantos.projetomaven.repositorios.RepositorioProduto;

@Service
public class ServicoProduto {
	
	@Autowired
	private RepositorioProduto repositorio;
	
	public List<Produto> todosProdutos(){
		return repositorio.findAll();
	}
	
	public Produto produtoPorId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}

}
