package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.ContactRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ContactRequestService {

    ContactRequest save(ContactRequest contactRequest);

    List<ContactRequest> findAll();

    Page<ContactRequest> search(String keyword, ContactRequest.ContactRequestStatus status, Pageable pageable);

    ContactRequest updateStatus(Long id, ContactRequest.ContactRequestStatus status);

    void deleteById(Long id);

}
