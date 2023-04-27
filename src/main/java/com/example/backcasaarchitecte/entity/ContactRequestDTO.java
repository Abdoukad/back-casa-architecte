package com.example.backcasaarchitecte.entity;

public class ContactRequestDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String subject;
    private String message;
    private String sendingDate;

    // Constructeur par défaut
    public ContactRequestDTO() {
    }

    // Constructeur avec paramètres
    public ContactRequestDTO(Long id, String fullName, String email, String phone, String subject, String message, String sendingDate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.message = message;
        this.sendingDate = sendingDate;
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

    public String getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(String sendingDate) {
        this.sendingDate = sendingDate;
    }
}
