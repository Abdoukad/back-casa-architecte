package com.example.backcasaarchitecte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

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
    }


}
