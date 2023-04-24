package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.ContactRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * Recherche les demandes de contact correspondant aux critères spécifiés (mot-clé et statut).
     * Les résultats sont paginés.
     *
     * @param keyword le mot-clé à rechercher
     * @param status le statut à filtrer
     * @param pageable les informations de pagination
     * @return la page de résultats correspondant aux critères spécifiés
     */
    Page<ContactRequest> search(String keyword, ContactRequest.ContactRequestStatus status, Pageable pageable);

    /**
     * Met à jour le statut d'une demande de contact existante.
     *
     * @param id l'identifiant de la demande de contact à mettre à jour
     * @param status le nouveau statut à affecter
     * @return la demande de contact mise à jour
     */
    ContactRequest updateStatus(Long id, ContactRequest.ContactRequestStatus status);

    /**
     * Supprime une demande de contact existante de la base de données.
     *
     * @param id l'identifiant de la demande de contact à supprimer
     */
    void deleteById(Long id);

}
