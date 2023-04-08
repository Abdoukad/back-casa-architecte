package com.example.backcasaarchitecte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backcasaarchitecte.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
