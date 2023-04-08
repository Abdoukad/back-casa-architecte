package com.example.backcasaarchitecte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.example.backcasaarchitecte.repository")
public class BackCasaArchitecteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackCasaArchitecteApplication.class, args);
	}
}
