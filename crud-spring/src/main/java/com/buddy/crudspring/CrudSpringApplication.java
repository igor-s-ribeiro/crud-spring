package com.buddy.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.buddy.crudspring.model.Pets;
import com.buddy.crudspring.model.Usuario;
import com.buddy.crudspring.model.Vacinas;

import com.buddy.crudspring.repository.PetsRepository;
import com.buddy.crudspring.repository.UsuarioRepository;
import com.buddy.crudspring.repository.VacinasRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(PetsRepository petsRepository) {
		return args -> {
			petsRepository.deleteAll();

			Pets p = new Pets();
			p.setName("");
			p.setCategory("");

			petsRepository.save(p);
		};
	}

	
	CommandLineRunner initDatabase(UsuarioRepository usuarioRepository) {
		return args -> {
			usuarioRepository.deleteAll();

			Usuario u = new Usuario();
			u.setName("");
			u.setCategory("");

			usuarioRepository.save(u);
		};
	}

	
	CommandLineRunner initDatabase(VacinasRepository vacinasRepository) {
		return args -> {
			vacinasRepository.deleteAll();

			Vacinas v = new Vacinas();
			v.setName("");
			v.setCategory("");

			vacinasRepository.save(v);
		};
	}
}
