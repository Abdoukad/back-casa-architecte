package com.example.backcasaarchitecte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backcasaarchitecte.entity.User;

/**
 * Interface représentant le repository pour l'entité User.
 * Elle étend JpaRepository pour fournir les méthodes de base CRUD (Create, Read, Update, Delete) pour l'entité User.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
