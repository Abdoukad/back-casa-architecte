package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.ContactRequest;
import java.util.List;

/**
 * Interface ContactRequestService définissant les opérations pour gérer les demandes de contact.
 */
public interface ContactRequestService {

    /**
     * Enregistre une demande de contact dans la base de données.
     *
     * @param contactRequest l'objet ContactRequest à enregistrer
     * @return l'objet ContactRequest enregistré avec son identifiant généré
     */
    ContactRequest save(ContactRequest contactRequest);

    /**
     * Récupère toutes les demandes de contact stockées dans la base de données.
     *
     * @return une liste de tous les objets ContactRequest
     */
    List<ContactRequest> findAll();
}
