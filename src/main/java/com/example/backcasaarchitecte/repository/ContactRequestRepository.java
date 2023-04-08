package com.example.backcasaarchitecte.repository;

import com.example.backcasaarchitecte.entity.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {
    // Ajoutez vos méthodes personnalisées ici si nécessaire
}
