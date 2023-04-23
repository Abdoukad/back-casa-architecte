package com.example.backcasaarchitecte.controller;

import com.example.backcasaarchitecte.entity.ContactRequest;
import com.example.backcasaarchitecte.service.ContactRequestService;
import com.example.backcasaarchitecte.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe contrôleur REST pour l'entité ContactRequest.
 * Cette classe gère les requêtes HTTP pour créer et récupérer des demandes de contact.
 */
@RestController
@RequestMapping("/api/contact-requests")
public class ContactRequestController {

    // Injecter l'instance de ContactRequestService à l'aide de l'annotation @Autowired
    @Autowired
    private ContactRequestService contactRequestService;

    @Autowired
    private EmailService emailService;

    /**
     * Méthode pour créer une nouvelle demande de contact (POST).
     * Elle appelle la méthode save() du service pour enregistrer la demande de contact.
     *
     * @param contactRequest l'objet ContactRequest à enregistrer
     * @return ResponseEntity avec l'objet ContactRequest enregistré
     */
    @PostMapping
    public ResponseEntity<ContactRequest> createContactRequest(@RequestBody ContactRequest contactRequest) {
        // Appeler la méthode save() du service pour enregistrer la demande de contact
        ContactRequest savedContactRequest = contactRequestService.save(contactRequest);

        // Send email notification
        String to = "casa-architecte@outlook.com";
        String subject = "Vous avez une nouvelle demande de contact";
        String text = "Une nouvelle demande de contact a été soumise avec les informations suivantes :\n\n" +
                "Nom complet : " + contactRequest.getFullName() + "\n" +
                "Email : " + contactRequest.getEmail() + "\n" +
                "Téléphone : " + contactRequest.getPhone() + "\n" +
                "Sujet : " + contactRequest.getSubject() + "\n" +
                "Message : " + contactRequest.getMessage() + "\n";

        emailService.sendEmail(to, subject, text);

        // Retourner la réponse HTTP avec l'objet ContactRequest enregistré
        return ResponseEntity.ok(savedContactRequest);
    }

    /**
     * Méthode pour récupérer toutes les demandes de contact (GET).
     * Elle appelle la méthode findAll() du service pour récupérer toutes les demandes de contact.
     *
     * @return ResponseEntity avec la liste des objets ContactRequest récupérés
     */
    @GetMapping
    public ResponseEntity<List<ContactRequest>> getAllContactRequests() {
        // Appeler la méthode findAll() du service pour récupérer toutes les demandes de contact
        List<ContactRequest> contactRequests = contactRequestService.findAll();
        // Retourner la réponse HTTP avec la liste des objets ContactRequest récupérés
        return ResponseEntity.ok(contactRequests);
    }
}
