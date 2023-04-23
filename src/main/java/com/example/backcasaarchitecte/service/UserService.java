package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.User;

/**
 * Interface représentant le service pour l'entité User.
 * Elle définit les méthodes spécifiques pour manipuler les données utilisateur.
 */
public interface UserService {

    /**
     * Enregistre un nouvel utilisateur dans la base de données.
     *
     * @param user l'objet User à enregistrer
     * @return l'objet User enregistré
     */
    User save(User user);
}
