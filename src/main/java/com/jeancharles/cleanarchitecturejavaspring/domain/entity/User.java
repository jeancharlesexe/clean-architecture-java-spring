package com.jeancharles.cleanarchitecturejavaspring.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

// --*USER ENTITY*--
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // applying factory method design pattern
    private User(String id, String name, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // factory method to create a new user
    public static User create(String name, String email, String password) {
        // possible validations

        // --------------------

        return new User(
                UUID.randomUUID().toString(),
                name,
                email,
                password,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    // factory method to build a user from database
    public static User restore(String id, String name, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new User(id, name, email, password, createdAt, updatedAt);
    }

    // possible validations

    // --------------------

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
