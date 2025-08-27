package com.jeancharles.cleanarchitecturejavaspring.infraestructure.presentation.controller;

import com.jeancharles.cleanarchitecturejavaspring.application.port.input.CreateUserInteractor;
import com.jeancharles.cleanarchitecturejavaspring.domain.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserInteractor createUserInteractor;

    public UserController(CreateUserInteractor createUserInteractor) {
        this.createUserInteractor = createUserInteractor;
    }

    @GetMapping
    public String getUsers() {
        return "testing tomcat 8080";
    }
    
    @PostMapping
    public void createUser(@RequestBody User user) {

    }
}
