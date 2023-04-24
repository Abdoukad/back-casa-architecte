package com.example.backcasaarchitecte.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Entité représentant une demande de contact.
 */
@Entity
@Table(name = "contact_request")
public class ContactRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "sending_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ContactRequestStatus status;

    /**
     * Constructeur par défaut.
     */
    public ContactRequest() {
    }

    /**
     * Constructeur avec paramètres.
     *
     * @param fullName le nom complet.
     * @param email    l'adresse e-mail.
     * @param phone    le numéro de téléphone.
     * @param subject  le sujet de la demande de contact.
     * @param message  le message de la demande de contact.
     */
    public ContactRequest(String fullName, String email, String phone, String subject, String message) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.message = message;
        this.sendingDate = new Date();
        this.status = ContactRequestStatus.NEW;
    }

    // Getters et setters pour chaque attribut

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public ContactRequestStatus getStatus() {
        return status;
    }

    public void setStatus(ContactRequestStatus status) {
        this.status = status;
    }

    /**
     * Énumération représentant les différents statuts possibles pour une demande de contact.
     */
    public enum ContactRequestStatus {
        NEW, IN_PROGRESS, COMPLETED, ARCHIVED
    }
}
