package com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.controller;

import com.jeancharles.cleanarchitecturejavaspring.application.core.port.input.CreateUserCommand;
import com.jeancharles.cleanarchitecturejavaspring.application.core.port.input.CreateUserInteractor;
import com.jeancharles.cleanarchitecturejavaspring.application.core.port.input.CreateUserResponse;
import com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.dto.user.CreateUserRequestDTO;
import com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.dto.user.CreateUserResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CreateUserResponseDTO> createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
        CreateUserCommand createUserCommand = new CreateUserCommand(
                createUserRequestDTO.name(),
                createUserRequestDTO.email(),
                createUserRequestDTO.password()
        );

        // execute use case
        CreateUserResponse response = createUserInteractor.execute(createUserCommand);

        // response as DTO
        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO(
                response.id(),
                response.name(),
                response.email(),
                response.createdAt()
        );

        // response as 200 if created
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

    }
}
