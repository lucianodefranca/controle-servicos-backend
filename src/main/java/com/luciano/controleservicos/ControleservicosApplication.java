package com.luciano.controleservicos;

import com.luciano.controleservicos.model.entities.Cliente;
import com.luciano.controleservicos.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ControleservicosApplication {

	public static void main(String[] args) {

		SpringApplication.run(ControleservicosApplication.class, args);
	}

}
