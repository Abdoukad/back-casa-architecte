package com.example.backcasaarchitecte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Cette classe est utilisée pour configurer Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        return manager;
    }

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
/*
        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.OPTIONS, "/**")
                .permitAll()
                .requestMatchers("/api/contact-requests")
        *//*        .permitAll()
                .requestMatchers("/api/contacts")
        *//*        .permitAll()
                .requestMatchers("/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .cors().disable()
                .formLogin()
                .successHandler(new RefererRedirectionAuthenticationSuccessHandler())
                .and()
                .oauth2Login()
                .defaultSuccessUrl("http://localhost:4200/admin ")
                .failureUrl("/loginFailure"); ;
        ;*/
        return http.authorizeHttpRequests().anyRequest().permitAll().and().csrf().disable().cors().disable().build();
/*
                http
                // Configurer les autorisations de requêtes HTTP.
                .authorizeHttpRequests(auth -> {

                    // Permettre à toutes les requêtes à l'endpoint "/".
*//*
                    auth.requestMatchers("/login*").permitAll();
*//*
         *//*
                    auth.requestMatchers("api/contact-requests").permitAll();
*//*

                    auth.requestMatchers( "/login")
                            .permitAll()
                            .anyRequest().authenticated();
                    //  auth.anyRequest().permitAll();
                    // Exiger une authentification pour toutes les autres requêtes.
                })
                // Configurer le login OAuth2 avec les paramètres par défaut.
                // Configurer le login par formulaire avec les paramètres par défaut.
                .formLogin(Customizer.withDefaults())
                /// Construire la chaîne de filtres de sécurité.
                .csrf().disable()
                .build();*/
    }

    @Bean
    public AuthorizationRequestRepository<OAuth2AuthorizationRequest>
    authorizationRequestRepository() {

        return new HttpSessionOAuth2AuthorizationRequestRepository();
    }
}
