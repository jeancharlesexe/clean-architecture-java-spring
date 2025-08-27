package com.jeancharles.cleanarchitecturejavaspring.infraestructure.persistence.jpa;

import com.jeancharles.cleanarchitecturejavaspring.infraestructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserEntity, String> {}
