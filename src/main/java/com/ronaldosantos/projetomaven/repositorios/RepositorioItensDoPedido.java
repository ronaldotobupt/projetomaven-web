package com.ronaldosantos.projetomaven.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronaldosantos.projetomaven.entidades.ItemDoPedido;
import com.ronaldosantos.projetomaven.entidades.chaveprimariacomposta.ItemDePedidoChavePrimaria;

public interface RepositorioItensDoPedido extends JpaRepository<ItemDoPedido, ItemDePedidoChavePrimaria> {

}