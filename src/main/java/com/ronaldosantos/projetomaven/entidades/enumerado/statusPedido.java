package com.ronaldosantos.projetomaven.entidades.enumerado;

public enum statusPedido {
	
	Aguardando_Pagamento(1),
	Pago(2),
	Enviado(3),
	Entregue(4),
	Cancelado(5);
	
	private int code;
	
	private statusPedido(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static statusPedido valor(int code) {
		for (statusPedido valor : statusPedido.values()) {
			if(valor.getCode() == code) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Codigo inválido!");
	}

}
