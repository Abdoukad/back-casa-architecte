package com.example.backcasaarchitecte.entity;

// Importations nécessaires pour les annotations JPA et les types de données



import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    // Indique que cette propriété est la clé primaire de la table
    @Id
    // Spécifie la stratégie de génération de la clé primaire (IDENTITY pour une colonne auto-incrémentée)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Spécifie le nom de la colonne dans la table de base de données, nullable = false signifie que cette colonne ne peut pas être vide
    // et unique = true signifie que chaque utilisateur doit avoir un nom d'utilisateur unique
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    // Spécifie le nom de la colonne dans la table de base de données et nullable = false signifie que cette colonne ne peut pas être vide
    @Column(name = "password", nullable = false)
    private String password;

    // Constructeur vide, nécessaire pour JPA
    public User() {
    }

    // Constructeur avec les paramètres username et password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters et setters pour les propriétés id, username et password
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}