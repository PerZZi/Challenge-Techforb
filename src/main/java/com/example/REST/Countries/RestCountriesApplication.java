package com.example.REST.Countries;

import com.example.REST.Countries.models.Usuario;
import com.example.REST.Countries.repositories.PlantaRepository;
import com.example.REST.Countries.repositories.SensorRepository;
import com.example.REST.Countries.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestCountriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCountriesApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(UsuarioRepository usuarioRepository, PlantaRepository plantaRepository, SensorRepository sensorRepository){
		return args -> {
			Usuario usuario = new Usuario("Emiliano", "Esteban Diaz", "emi@gmail.com", "emi123");
			usuarioRepository.save(usuario);
		};
	}
}
