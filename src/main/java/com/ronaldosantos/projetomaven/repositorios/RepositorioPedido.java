package com.ronaldosantos.projetomaven.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronaldosantos.projetomaven.entidades.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

}
