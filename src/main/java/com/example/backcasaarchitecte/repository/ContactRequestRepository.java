package com.example.backcasaarchitecte.repository;

import com.example.backcasaarchitecte.entity.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Repository pour gérer les opérations de base de données liées aux demandes de contact.
 */
public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {

    /**
     * Recherche des demandes de contact en fonction de critères de recherche (mot-clé, statut).
     *
     * @param keyword  mot-clé pour la recherche (facultatif).
     * @param status   statut des demandes de contact à rechercher (facultatif).
     * @param pageable objet Pageable pour la pagination.
     * @return Page de demandes de contact correspondant aux critères de recherche.
     */
    @Query("SELECT c FROM ContactRequest c WHERE (:keyword IS NULL OR (c.fullName LIKE %:keyword% OR c.email LIKE %:keyword% OR c.subject LIKE %:keyword%)) AND (:status IS NULL OR c.status = :status)")
    Page<ContactRequest> search(@Param("keyword") String keyword, @Param("status") ContactRequest.ContactRequestStatus status, Pageable pageable);
}
