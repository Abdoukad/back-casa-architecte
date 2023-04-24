package com.example.backcasaarchitecte.service;

import com.example.backcasaarchitecte.entity.ContactRequest;
import com.example.backcasaarchitecte.repository.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactRequestServiceImpl implements ContactRequestService {

    @Autowired
    private ContactRequestRepository contactRequestRepository;

    @Override
    public ContactRequest save(ContactRequest contactRequest) {
        return contactRequestRepository.save(contactRequest);
    }

    @Override
    public List<ContactRequest> findAll() {
        return contactRequestRepository.findAll();
    }

    @Override
    public Page<ContactRequest> search(String keyword, ContactRequest.ContactRequestStatus status, Pageable pageable) {
        return contactRequestRepository.search(keyword, status, pageable);
    }

    @Override
    public ContactRequest updateStatus(Long id, ContactRequest.ContactRequestStatus status) {
        Optional<ContactRequest> optionalContactRequest = contactRequestRepository.findById(id);

        if (optionalContactRequest.isPresent()) {
            ContactRequest contactRequest = optionalContactRequest.get();
            contactRequest.setStatus(status);
            return contactRequestRepository.save(contactRequest);
        } else {
            throw new RuntimeException("ContactRequest not found with id: " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        contactRequestRepository.deleteById(id);
    }
}
