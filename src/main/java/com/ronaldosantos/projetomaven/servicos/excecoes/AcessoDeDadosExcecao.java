package com.ronaldosantos.projetomaven.servicos.excecoes;

public class AcessoDeDadosExcecao extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AcessoDeDadosExcecao(String msg) {
		super (msg);
	}

}
