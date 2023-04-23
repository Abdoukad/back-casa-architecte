package com.example.backcasaarchitecte.repository;

import com.example.backcasaarchitecte.entity.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {

    @Query("SELECT c FROM ContactRequest c WHERE (:keyword IS NULL OR (c.fullName LIKE %:keyword% OR c.email LIKE %:keyword% OR c.subject LIKE %:keyword%)) AND (:status IS NULL OR c.status = :status)")
    Page<ContactRequest> search(@Param("keyword") String keyword, @Param("status") ContactRequest.ContactRequestStatus status, Pageable pageable);
}
