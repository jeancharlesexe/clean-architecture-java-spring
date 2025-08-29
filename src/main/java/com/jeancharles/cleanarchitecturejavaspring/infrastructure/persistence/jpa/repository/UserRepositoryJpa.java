package com.jeancharles.cleanarchitecturejavaspring.infrastructure.persistence.jpa.repository;

import com.jeancharles.cleanarchitecturejavaspring.infrastructure.persistence.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserEntity, String> {
    Boolean existsByEmail(String email);
}
