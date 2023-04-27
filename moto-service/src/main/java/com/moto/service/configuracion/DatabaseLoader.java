package com.moto.service.configuracion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.moto.service.entidades.Moto;
import com.moto.service.repositorio.MotoRepository;


@Configuration
public class DatabaseLoader {

	@Bean
	CommandLineRunner init(MotoRepository repository) {
		return args -> {
			repository.save(new Moto(1,"Yamaha","YM-A",2));
			repository.save(new Moto(2,"Italika","I1",2));
			repository.save(new Moto(3,"Susuki","vesda",2));
			repository.save(new Moto(4,"Yamaha","YM-A",1));
		};
	}
}
