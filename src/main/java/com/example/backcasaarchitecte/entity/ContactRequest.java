package com.example.backcasaarchitecte.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Classe représentant l'entité demande de contact dans la base de données.
 */
@Entity
@Table(name = "contact_request")
public class ContactRequest {

    /**
     * Identifiant unique de la demande de contact, clé primaire dans la table des demandes de contact.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nom complet de la personne ayant soumis la demande de contact, ne peut pas être vide.
     */
    @Column(name = "full_name", nullable = false)
    private String fullName;

    /**
     * Adresse e-mail de la personne ayant soumis la demande de contact, ne peut pas être vide.
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Numéro de téléphone de la personne ayant soumis la demande de contact, ne peut pas être vide.
     */
    @Column(name = "phone", nullable = false)
    private String phone;

    /**
     * Sujet de la demande de contact, ne peut pas être vide.
     */
    @Column(name = "subject", nullable = false)
    private String subject;

    /**
     * Message de la demande de contact, ne peut pas être vide.
     */
    @Column(name = "message", nullable = false)
    private String message;

    /**
     * Date d'envoi de la demande de contact.
     */
    @Column(name = "sending_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ContactRequestStatus status;


    /**
     * Constructeur vide, nécessaire pour JPA.
     */
    public ContactRequest() {
    }

    /**
     * Constructeur avec les attributs de la classe en paramètres.
     *
     * @param fullName le nom complet de la personne ayant soumis la demande de contact
     * @param email    l'adresse e-mail de la personne ayant soumis la demande de contact
     * @param phone    le numéro de téléphone de la personne ayant soumis la demande de contact
     * @param subject  le sujet de la demande de contact
     * @param message  le message de la demande de contact
     * @param status   le status de la demande de contact
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

    /**
     * Récupère l'identifiant unique de la demande de contact.
     *
     * @return l'identifiant de la demande de contact
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique de la demande de contact.
     *
     * @param id l'identifiant à définir
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Récupère le nom complet de la personne ayant soumis la demande de contact.
     *
     * @return le nom complet
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Définit le nom complet de la personne ayant soumis la demande de contact.
     *
     * @param fullName le nom complet à définir
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Récupère l'adresse e-mail de la personne ayant soumis la demande de contact.
     *
     * @return l'adresse e-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit l'adresse e-mail de la personne ayant soumis la demande de contact.
     *
     * @param email l'adresse e-mail à définir
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Récupère le numéro de téléphone de la personne ayant soumis la demande de contact.
     *
     * @return le numéro de téléphone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Définit le numéro de téléphone de la personne ayant soumis la demande de contact.
     *
     * @param phone le numéro de téléphone à définir
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Récupère le sujet de la demande de contact.
     *
     * @return le sujet
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Définit le sujet de la demande de contact.
     *
     * @param subject le sujet à définir
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Récupère le message de la demande de contact.
     *
     * @return le message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Définit le message de la demande de contact.
     *
     * @param message le message à définir
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Récupère la date d'envoi de la demande de contact.
     *
     * @return la date d'envoi
     */
    public Date getSendingDate() {
        return sendingDate;
    }

    /**
     * Définit la date d'envoi de la demande de contact.
     *
     * @param sendingDate la date d'envoi à définir
     */
    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public ContactRequestStatus getStatus() {
        return status;
    }

    public void setStatus(ContactRequestStatus status) {
        this.status = status;
    }

    public enum ContactRequestStatus {
        NEW, IN_PROGRESS, COMPLETED, ARCHIVED
    }
}