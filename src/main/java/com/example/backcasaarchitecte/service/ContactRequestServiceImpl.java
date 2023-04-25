package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.ContactRequest;
import com.example.backcasaarchitecte.repository.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactRequestServiceImpl implements ContactRequestService {

    @Autowired
    private ContactRequestRepository contactRequestRepository;

    /**
     * Enregistre une demande de contact
     *
     * @param contactRequest la demande de contact à enregistrer
     * @return la demande de contact enregistrée
     */
    @Override
    public ContactRequest save(ContactRequest contactRequest) {
        return contactRequestRepository.save(contactRequest);
    }

    /**
     * Récupère toutes les demandes de contact
     *
     * @return la liste de toutes les demandes de contact
     */
    @Override
    public List<ContactRequest> findAll() {
        return contactRequestRepository.findAll();
    }

    /**
     * Supprime une demande de contact donnée
     *
     * @param id l'identifiant de la demande de contact à supprimer
     */
    @Override
    public void deleteById(Long id) {
        contactRequestRepository.deleteById(id);
    }
}
