package com.carro.service.configuracion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.carro.service.entidades.Carro;
import com.carro.service.repositorio.CarroRepository;


@Configuration
public class DatabaseLoader {
	
	@Bean
	CommandLineRunner init(CarroRepository repository) {
		return args -> {
			repository.save(new Carro(1,"Mercedes","Benz",1));
			repository.save(new Carro(2,"Audi","A1",1));
			repository.save(new Carro(3,"Nisan","Ns",1));
			repository.save(new Carro(4,"Audi","A1",2));
		};
	}
}
