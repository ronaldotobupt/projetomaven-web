package com.ronaldosantos.projetomaven.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldosantos.projetomaven.entidades.Usuario;
import com.ronaldosantos.projetomaven.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;
	
	public List<Usuario> todosUsuarios(){
		return repositorio.findAll();
	}
	
	public Usuario usuarioPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}

}
