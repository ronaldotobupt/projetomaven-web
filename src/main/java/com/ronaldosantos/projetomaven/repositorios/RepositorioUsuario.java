package com.ronaldosantos.projetomaven.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronaldosantos.projetomaven.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
