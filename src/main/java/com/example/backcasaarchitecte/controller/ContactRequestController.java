package com.example.backcasaarchitecte.controller;

import com.example.backcasaarchitecte.entity.ContactRequest;
import com.example.backcasaarchitecte.entity.ContactRequestDTO;
import com.example.backcasaarchitecte.service.ContactRequestService;
import com.example.backcasaarchitecte.service.EmailService;
import com.example.backcasaarchitecte.entity.ArchivedContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Contrôleur REST pour gérer les demandes de contact.
 */
@RestController
@RequestMapping("/api/contact-requests")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:62913"})
public class ContactRequestController {

    @Autowired
    private ContactRequestService contactRequestService; // service pour gérer les demandes de contact

    @Autowired
    private EmailService emailService; // service pour envoyer des e-mails

    /**
     * Créer une nouvelle demande de contact.
     *
     * @param contactRequest objet ContactRequest contenant les informations de la demande de contact.
     * @return ResponseEntity avec l'objet ContactRequest sauvegardé.
     */
    @PostMapping
    public ResponseEntity<ContactRequest> createContactRequest(@RequestBody ContactRequest contactRequest) {
        contactRequest.setSendingDate(LocalDateTime.now());
        ContactRequest savedContactRequest = contactRequestService.save(contactRequest);

        // Envoyer une notification par e-mail à l'adresse "casa-architecte@outlook.com"
        String to = "casa-architecte@outlook.com";
        String subject = "Vous avez une nouvelle demande de contact";
        String text = "Une nouvelle demande de contact a été soumise avec les informations suivantes :\n\n" +
                "Nom complet : " + contactRequest.getFullName() + "\n" +
                "Email : " + contactRequest.getEmail() + "\n" +
                "Téléphone : " + contactRequest.getPhone() + "\n" +
                "Sujet : " + contactRequest.getSubject() + "\n" +
                "Message : " + contactRequest.getMessage() + "\n";

        emailService.sendEmail(to, subject, text);

        return ResponseEntity.ok(savedContactRequest);
    }

    /**
     * Récupérer toutes les demandes de contact.
     *
     * @return ResponseEntity avec la liste de toutes les demandes de contact.
     */
    @GetMapping
    public ResponseEntity<List<ContactRequestDTO>> getAllContactRequests() {
        List<ContactRequest> contactRequests = contactRequestService.findAll();
        List<ContactRequestDTO> contactRequestDTOs = new ArrayList<>();

        for (ContactRequest request : contactRequests) {
            ContactRequestDTO dto = new ContactRequestDTO();
            dto.setId(request.getId());
            dto.setFullName(request.getFullName());
            dto.setEmail(request.getEmail());
            dto.setPhone(request.getPhone());
            dto.setSubject(request.getSubject());
            dto.setMessage(request.getMessage());
            dto.setSendingDate(request.getSendingDate().toString());
            contactRequestDTOs.add(dto);
        }

        return ResponseEntity.ok(contactRequestDTOs);
    }

    /**
     * Supprimer une demande de contact.
     *
     * @param id identifiant de la demande de contact à supprimer.
     * @return ResponseEntity vide avec le statut HTTP No Content (204).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactRequest(@PathVariable Long id) { // identifiant de la demande de contact à supprimer
        contactRequestService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Archiver une demande de contact.
     *
     * @param id identifiant de la demande de contact à archiver.
     * @return ResponseEntity avec l'objet ArchivedContactRequest sauvegardé.
     */
    @PostMapping("/archive/{id}")
    public ResponseEntity<ArchivedContactRequest> archiveContactRequest(@PathVariable Long id) {
        ArchivedContactRequest archivedContactRequest = contactRequestService.archiveById(id);
        return ResponseEntity.ok(archivedContactRequest);
    }

    /**
     * Récupérer toutes les demandes de contact archivées.
     *
     * @return ResponseEntity avec la liste de toutes les demandes de contact archivées.
     */
    @GetMapping("/archived")
    public ResponseEntity<List<ArchivedContactRequest>> getAllArchivedContactRequests() {
        List<ArchivedContactRequest> archivedContactRequests = contactRequestService.findAllArchived();
        return ResponseEntity.ok(archivedContactRequests);
    }

}
