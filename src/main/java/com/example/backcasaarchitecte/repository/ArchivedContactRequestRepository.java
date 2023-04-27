package com.example.backcasaarchitecte.repository;

import com.example.backcasaarchitecte.entity.ArchivedContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour gérer les opérations de base de données liées aux demandes de contact archivées.
 */
public interface ArchivedContactRequestRepository extends JpaRepository<ArchivedContactRequest, Long> {

}
