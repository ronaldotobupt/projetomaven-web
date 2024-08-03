package com.ronaldosantos.projetomaven.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronaldosantos.projetomaven.entidades.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long> {

}
