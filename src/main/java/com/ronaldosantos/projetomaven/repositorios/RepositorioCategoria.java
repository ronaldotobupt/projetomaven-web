package com.ronaldosantos.projetomaven.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronaldosantos.projetomaven.entidades.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

}
