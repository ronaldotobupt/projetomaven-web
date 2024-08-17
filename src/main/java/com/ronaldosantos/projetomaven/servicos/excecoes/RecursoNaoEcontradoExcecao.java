package com.ronaldosantos.projetomaven.servicos.excecoes;

public class RecursoNaoEcontradoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RecursoNaoEcontradoExcecao (Object id) {
		super("Recurso não encontrado. Id"+ id);
	}
	
	

}
