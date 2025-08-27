package com.jeancharles.cleanarchitecturejavaspring.application.core.user.port.input;

import java.time.LocalDateTime;

// results (output) of use case in action
public record CreateUserResponse(String id, String name, String email, LocalDateTime createdAt) { }
