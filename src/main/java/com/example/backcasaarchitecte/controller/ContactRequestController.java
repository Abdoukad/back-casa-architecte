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
import java.util.Arrays;
import java.util.List;

/**
 * Contrôleur REST pour gérer les demandes de contact.
 */
@RestController
@RequestMapping("/api/contact-requests")
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

/*
        emailService.sendEmail(to, subject, text);
*/

        return ResponseEntity.ok(savedContactRequest);
    }



}
