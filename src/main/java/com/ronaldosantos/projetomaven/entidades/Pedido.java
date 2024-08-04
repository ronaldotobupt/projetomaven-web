package com.ronaldosantos.projetomaven.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ronaldosantos.projetomaven.entidades.enumerado.statusPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataPedido;
	
	private Integer StatusPedido;
	
	//Associação Pedido - cliente (Muitos para 01 - 01 cliente pode ter vários pedidos)
	//Informando ao JPA a criação de chave estrangeira na pedidos
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")//Nome do campo chave estrangeira
	private Usuario cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemDoPedido> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido() {
		
	}

	public Pedido(Long id, Instant dataPedido,statusPedido StatusPedido, Usuario cliente) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		setStatusPedido(StatusPedido);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	

	public statusPedido getStatusPedido() {
		return statusPedido.valor(StatusPedido);
	}

	public void setStatusPedido(statusPedido statusPedido) {
		if(statusPedido != null) {
		StatusPedido = statusPedido.getCode();
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemDoPedido> getItens(){
		return itens;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
