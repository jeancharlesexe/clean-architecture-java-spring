package com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.dto.user;

public record CreateUserRequestDTO(String name, String email, String password) {}