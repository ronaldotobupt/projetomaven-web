package com.ronaldosantos.projetomaven.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ronaldosantos.projetomaven.entidades.Pedido;
import com.ronaldosantos.projetomaven.entidades.Usuario;
import com.ronaldosantos.projetomaven.entidades.enumerado.statusPedido;
import com.ronaldosantos.projetomaven.repositorios.RepositorioPedido;
import com.ronaldosantos.projetomaven.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),statusPedido.Pago,u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), statusPedido.Aguardando_Pagamento, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),statusPedido.Aguardando_Pagamento, u1);
		
		
		repositorioUsuario.saveAll(Arrays.asList(u1,u2));
		repositorioPedido.saveAll(Arrays.asList(o1,o2,o3));
	}

}
