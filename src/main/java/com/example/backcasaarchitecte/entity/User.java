package com.example.backcasaarchitecte.entity;

import jakarta.persistence.*;

/**
 * Classe représentant l'entité utilisateur dans la base de données.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Identifiant unique de l'utilisateur, clé primaire dans la table des utilisateurs.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nom d'utilisateur de l'utilisateur, doit être unique et non vide.
     */
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /**
     * Mot de passe de l'utilisateur, ne peut pas être vide.
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Constructeur vide, nécessaire pour JPA.
     */
    public User() {
    }

    /**
     * Constructeur avec les paramètres username et password.
     *
     * @param username le nom d'utilisateur de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Récupère l'identifiant unique de l'utilisateur.
     *
     * @return l'identifiant de l'utilisateur
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique de l'utilisateur.
     *
     * @param id l'identifiant à définir
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Récupère le nom d'utilisateur de l'utilisateur.
     *
     * @return le nom d'utilisateur
     */
    public String getUsername() {
        return username;
    }

    /**
     * Définit le nom d'utilisateur de l'utilisateur.
     *
     * @param username le nom d'utilisateur à définir
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Récupère le mot de passe de l'utilisateur.
     *
     * @return le mot de passe
     */
    public String getPassword() {
        return password;
    }

    /**
     * Définit le mot de passe de l'utilisateur.
     *
     * @param password le mot de passe à définir
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
