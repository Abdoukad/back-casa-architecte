package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.ContactRequest;
import com.example.backcasaarchitecte.entity.ArchivedContactRequest;

import java.util.List;

public interface ContactRequestService {

    /**
     * Sauvegarde une demande de contact dans la base de données.
     *
     * @param contactRequest la demande de contact à sauvegarder
     * @return la demande de contact sauvegardée
     */
    ContactRequest save(ContactRequest contactRequest);

    /**
     * Récupère toutes les demandes de contact enregistrées dans la base de données.
     *
     * @return la liste des demandes de contact
     */
    List<ContactRequest> findAll();

    /**
     * Supprime une demande de contact existante de la base de données.
     *
     * @param id l'identifiant de la demande de contact à supprimer
     */
    void deleteById(Long id);

    /**
     * Archive une demande de contact existante.
     *
     * @param id l'identifiant de la demande de contact à archiver
     * @return la demande de contact archivée
     */
    ArchivedContactRequest archiveById(Long id);

    /**
     * Récupère toutes les demandes de contact archivées enregistrées dans la base de données.
     *
     * @return la liste des demandes de contact archivées
     */
    List<ArchivedContactRequest> findAllArchived();
}
