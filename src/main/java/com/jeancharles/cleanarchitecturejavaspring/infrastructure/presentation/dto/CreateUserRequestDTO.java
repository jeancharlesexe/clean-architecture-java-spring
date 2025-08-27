package com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.dto;

public record CreateUserRequestDTO(String name, String email, String password) {}