package com.example.backcasaarchitecte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe principale de l'application BackCasaArchitecte.
 * Cette classe est annotée avec @SpringBootApplication pour indiquer à Spring Boot que c'est la classe principale de l'application.
 */
@SpringBootApplication
public class BackCasaArchitecteApplication {

	/**
	 * Méthode main de l'application, qui démarre le serveur Spring Boot.
	 *
	 * @param args les arguments de la ligne de commande
	 */
	public static void main(String[] args) {
		SpringApplication.run(BackCasaArchitecteApplication.class, args);
		System.out.println("olelelelelelele");
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200"); // Remplacez l'URL par l'URL de votre application Angular si nécessaire
			}
		};
}}
