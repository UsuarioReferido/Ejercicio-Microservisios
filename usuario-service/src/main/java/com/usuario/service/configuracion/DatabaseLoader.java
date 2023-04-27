package com.usuario.service.configuracion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.repositorio.UsuarioRepository;


@Configuration
public class DatabaseLoader {

	@Bean
	CommandLineRunner init(UsuarioRepository repository) {
		return args -> {
			repository.save(new Usuario(1,"Pedro","Pedro@gmail.com"));
			repository.save(new Usuario(2,"Luis","Luis@gmail.com"));
		};
	}
}
