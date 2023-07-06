package com.example.backcasaarchitecte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Cette classe est utilisée pour configurer Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configure la chaîne de filtres de sécurité. Cette méthode est invoquée par Spring
     * pour créer un bean qui représente la chaîne de filtres de sécurité.
     *
     * @param http L'objet HttpSecurity, qui est utilisé pour configurer la sécurité web.
     * @return La chaîne de filtres de sécurité.
     * @throws Exception Si une erreur se produit lors de la configuration de la sécurité.
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // Configurer les autorisations de requêtes HTTP.
                .authorizeHttpRequests(auth -> {
                    // Permettre à toutes les requêtes à l'endpoint "/".
                    auth.requestMatchers("/").permitAll();
                    // Exiger une authentification pour toutes les autres requêtes.
                    auth.anyRequest().authenticated();
                })
                // Configurer le login OAuth2 avec les paramètres par défaut.
                .oauth2Login(withDefaults())
                // Configurer le login par formulaire avec les paramètres par défaut.
                .formLogin(Customizer.withDefaults())
                // Construire la chaîne de filtres de sécurité.
                .build();
    }
}
