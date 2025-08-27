package com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.dto.user;

import java.time.LocalDateTime;

public record CreateUserResponseDTO(String id, String name, String email, LocalDateTime createdAt) {}
