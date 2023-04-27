package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.ArchivedContactRequest;
import com.example.backcasaarchitecte.entity.ContactRequest;
import com.example.backcasaarchitecte.repository.ArchivedContactRequestRepository;
import com.example.backcasaarchitecte.repository.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactRequestServiceImpl implements ContactRequestService {

    @Autowired
    private ContactRequestRepository contactRequestRepository;

    @Autowired
    private ArchivedContactRequestRepository archivedContactRequestRepository;

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

    /**
     * Archive une demande de contact en la déplaçant de la table contact_request vers la table archived_contact_request.
     *
     * @param id l'identifiant de la demande de contact à archiver
     * @return la demande de contact archivée
     */
    @Override
    public ArchivedContactRequest archiveById(Long id) {
        // Trouvez la demande de contact par son ID
        ContactRequest contactRequest = contactRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("ContactRequest not found"));

        // Créez une nouvelle instance d'ArchivedContactRequest avec les mêmes attributs que la demande de contact trouvée
        ArchivedContactRequest archivedContactRequest = new ArchivedContactRequest();
        archivedContactRequest.setFullName(contactRequest.getFullName());
        archivedContactRequest.setEmail(contactRequest.getEmail());
        archivedContactRequest.setPhone(contactRequest.getPhone());
        archivedContactRequest.setSubject(contactRequest.getSubject());
        archivedContactRequest.setMessage(contactRequest.getMessage());
        archivedContactRequest.setSendingDate(contactRequest.getSendingDate());

        // Sauvegardez l'instance d'ArchivedContactRequest dans la base de données
        archivedContactRequestRepository.save(archivedContactRequest);

        // Supprimez la demande de contact originale
        contactRequestRepository.deleteById(id);

        // Retournez la demande de contact archivée
        return archivedContactRequest;
    }

    /**
     * Récupère toutes les demandes de contact archivées
     *
     * @return la liste de toutes les demandes de contact archivées
     */
    @Override
    public List<ArchivedContactRequest> findAllArchived() {
        return archivedContactRequestRepository.findAll();
    }
}