package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.ContactRequest;
import com.example.backcasaarchitecte.repository.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     * Recherche les demandes de contact correspondant à un mot-clé et/ou un statut donné
     * avec une pagination donnée
     *
     * @param keyword le mot-clé à rechercher dans les demandes de contact (peut être null)
     * @param status le statut des demandes de contact à rechercher (peut être null)
     * @param pageable les informations de pagination (numéro de page, taille de page, tri, etc.)
     * @return la page de demandes de contact correspondant aux critères de recherche
     */
    @Override
    public Page<ContactRequest> search(String keyword, ContactRequest.ContactRequestStatus status, Pageable pageable) {
        return contactRequestRepository.search(keyword, status, pageable);
    }

    /**
     * Met à jour le statut d'une demande de contact donnée
     *
     * @param id l'identifiant de la demande de contact à mettre à jour
     * @param status le nouveau statut à attribuer à la demande de contact
     * @return la demande de contact mise à jour
     * @throws RuntimeException si aucune demande de contact n'a été trouvée avec l'identifiant donné
     */
    @Override
    public ContactRequest updateStatus(Long id, ContactRequest.ContactRequestStatus status) {
        Optional<ContactRequest> optionalContactRequest = contactRequestRepository.findById(id);

        if (optionalContactRequest.isPresent()) {
            ContactRequest contactRequest = optionalContactRequest.get();
            contactRequest.setStatus(status);
            return contactRequestRepository.save(contactRequest);
        } else {
            throw new RuntimeException("ContactRequest not found with id: " + id);
        }
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
