package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.ContactRequest;
import com.example.backcasaarchitecte.repository.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implémentation de l'interface ContactRequestService pour définir les méthodes
 * de gestion des demandes de contact.
 */
@Service
public class ContactRequestServiceImpl implements ContactRequestService {

    // Injection de l'instance de ContactRequestRepository à l'aide de l'annotation @Autowired
    @Autowired
    private ContactRequestRepository contactRequestRepository;

    /**
     * Enregistre une demande de contact dans la base de données.
     *
     * @param contactRequest l'objet ContactRequest à enregistrer
     * @return l'objet ContactRequest enregistré avec son identifiant généré
     */
    @Override
    public ContactRequest save(ContactRequest contactRequest) {
        // Utiliser la méthode save() de contactRequestRepository pour enregistrer l'entité contactRequest
        return contactRequestRepository.save(contactRequest);
    }

    /**
     * Récupère toutes les demandes de contact stockées dans la base de données.
     *
     * @return une liste de tous les objets ContactRequest
     */
    @Override
    public List<ContactRequest> findAll() {
        // Utiliser la méthode findAll() de contactRequestRepository pour récupérer tous les enregistrements de ContactRequest
        return contactRequestRepository.findAll();
    }
}
