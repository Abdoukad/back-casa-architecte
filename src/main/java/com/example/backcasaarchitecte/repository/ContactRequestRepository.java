package com.example.backcasaarchitecte.repository;

import com.example.backcasaarchitecte.entity.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour gérer les opérations de base de données liées aux demandes de contact.
 */
public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {

}
