package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.User;
import com.example.backcasaarchitecte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe implémentant l'interface UserService pour définir les méthodes spécifiques de manipulation des données utilisateur.
 * Cette classe est annotée avec @Service pour indiquer à Spring qu'il s'agit d'une classe de service.
 */
@Service
public class UserServiceImpl implements UserService {

    // Injecter l'instance de UserRepository à l'aide de l'annotation @Autowired
    @Autowired
    private UserRepository userRepository;

    /**
     * Implémentation de la méthode save() de l'interface UserService.
     * Enregistre un nouvel utilisateur dans la base de données en utilisant la méthode save() de UserRepository.
     *
     * @param user l'objet User à enregistrer
     * @return l'objet User enregistré
     */
    @Override
    public User save(User user) {
        // Utiliser la méthode save() de userRepository pour enregistrer l'entité user
        return userRepository.save(user);
    }
}
