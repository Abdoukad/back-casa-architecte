package com.example.backcasaarchitecte.controller;

import com.example.backcasaarchitecte.entity.ContactRequest;
import com.example.backcasaarchitecte.service.ContactRequestService;
import com.example.backcasaarchitecte.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-requests")
@CrossOrigin(origins = "http://localhost:56786")
public class ContactRequestController {

    @Autowired
    private ContactRequestService contactRequestService;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<ContactRequest> createContactRequest(@RequestBody ContactRequest contactRequest) {
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

        return ResponseEntity.ok(savedContactRequest);
    }

    @GetMapping
    public ResponseEntity<List<ContactRequest>> getAllContactRequests() {
        List<ContactRequest> contactRequests = contactRequestService.findAll();
        return ResponseEntity.ok(contactRequests);
    }


    @GetMapping("/search")
    public ResponseEntity<Page<ContactRequest>> searchContactRequests(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) ContactRequest.ContactRequestStatus status,
            Pageable pageable) {
        Page<ContactRequest> contactRequests = contactRequestService.search(keyword, status, pageable);
        return ResponseEntity.ok(contactRequests);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ContactRequest> updateContactRequestStatus(
            @PathVariable Long id,
            @RequestParam ContactRequest.ContactRequestStatus status) {
        ContactRequest updatedContactRequest = contactRequestService.updateStatus(id, status);
        return ResponseEntity.ok(updatedContactRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactRequest(@PathVariable Long id) {
        contactRequestService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
