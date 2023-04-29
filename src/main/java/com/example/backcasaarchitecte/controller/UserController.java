package com.example.backcasaarchitecte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Classe UserController qui gère les requêtes HTTP pour les opérations sur les utilisateurs.
 * Cette classe est un contrôleur REST avec le chemin de base '/api/users'.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    // Injecter l'instance de UserService à l'aide de l'annotation @Autowired
    @Autowired
    private UserService userService;

    /**
     * Méthode pour créer un nouvel utilisateur (POST).
     *
     * @param user l'objet User à enregistrer
     * @return ResponseEntity<User> une réponse HTTP contenant l'objet User enregistré
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        // Appeler la méthode save() du service pour enregistrer l'utilisateur
        User savedUser = userService.save(user);

        // Retourner la réponse HTTP avec l'objet User enregistré
        return ResponseEntity.ok(savedUser);
    }
}
