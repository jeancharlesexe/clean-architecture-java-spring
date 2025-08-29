package com.jeancharles.cleanarchitecturejavaspring.core.application.user.port.input;

// Command - an example of data entry to contract use
public record CreateUserCommand(String name, String email, String password) {}
