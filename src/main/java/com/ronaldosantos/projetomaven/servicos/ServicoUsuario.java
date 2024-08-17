package com.ronaldosantos.projetomaven.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ronaldosantos.projetomaven.entidades.Usuario;
import com.ronaldosantos.projetomaven.repositorios.RepositorioUsuario;
import com.ronaldosantos.projetomaven.servicos.excecoes.AcessoDeDadosExcecao;
import com.ronaldosantos.projetomaven.servicos.excecoes.RecursoNaoEcontradoExcecao;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;

	public List<Usuario> todosUsuarios() {
		return repositorio.findAll();
	}

	public Usuario usuarioPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEcontradoExcecao(id));
	}

	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		repositorio.findById(id).orElseThrow(() -> new RecursoNaoEcontradoExcecao(id));
		try {
			repositorio.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		catch(DataIntegrityViolationException e) {
			throw new AcessoDeDadosExcecao(e.getMessage());
		}
		
	}
	
	

	public Usuario update(Long id, Usuario obj) {
		Usuario entity = repositorio.getReferenceById(id);
		atualizarDados(entity, obj);
		return repositorio.save(entity);
	}

	private void atualizarDados(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}

}
