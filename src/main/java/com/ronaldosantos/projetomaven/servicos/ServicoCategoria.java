package com.ronaldosantos.projetomaven.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldosantos.projetomaven.entidades.Categoria;
import com.ronaldosantos.projetomaven.repositorios.RepositorioCategoria;

@Service
public class ServicoCategoria {
	
	@Autowired
	private RepositorioCategoria repositorio;
	
	public List<Categoria> todosCategorias(){
		return repositorio.findAll();
	}
	
	public Categoria categoriaPorId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}

}
