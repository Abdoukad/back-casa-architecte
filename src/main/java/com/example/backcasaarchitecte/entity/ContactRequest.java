package com.example.backcasaarchitecte.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

// L'annotation @Entity indique que cette classe doit être mappée à une table de base de données
@Entity
// L'annotation @Table spécifie le nom de la table à laquelle cette classe doit être mappée
@Table(name = "contact_request")
public class ContactRequest {

    // L'annotation @Id indique que cet attribut est la clé primaire de la table
    @Id
    // L'annotation @GeneratedValue spécifie la stratégie de génération de la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // L'annotation @Column spécifie les propriétés de la colonne associée à cet attribut
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

    // Constructeurs, getters et setters

    // Constructeur par défaut requis par JPA
    public ContactRequest() {
    }

    // Constructeur avec les attributs de la classe en paramètres
    public ContactRequest(String fullName, String email, String phone, String subject, String message) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.message = message;
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
}