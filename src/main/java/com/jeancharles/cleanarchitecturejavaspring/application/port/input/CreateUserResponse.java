package com.jeancharles.cleanarchitecturejavaspring.application.port.input;

import java.time.LocalDateTime;

// results (output) of use case in action
public record CreateUserResponse(String id, String name, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt) { }
