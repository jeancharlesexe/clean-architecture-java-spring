package com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.controller;

import com.jeancharles.cleanarchitecturejavaspring.core.application.user.port.input.CreateUserCommand;
import com.jeancharles.cleanarchitecturejavaspring.core.application.user.port.CreateUserUseCase;
import com.jeancharles.cleanarchitecturejavaspring.core.application.user.port.output.CreateUserResponse;
import com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.dto.GlobalApiResponse;
import com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.dto.user.CreateUserRequestDTO;
import com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.dto.user.CreateUserResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUseCase createUserInteractor;

    public UserController(CreateUserUseCase createUserInteractor) {
        this.createUserInteractor = createUserInteractor;
    }

    @GetMapping
    public String getUsers() {
        return "testing tomcat 8080";
    }

    @PostMapping
    public ResponseEntity<GlobalApiResponse<CreateUserResponseDTO>> createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
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
        return ResponseEntity.status(HttpStatus.CREATED).body(
            new GlobalApiResponse<>(
                    HttpStatus.CREATED.value(),
                    "User created successfully",
                    responseDTO,
                    LocalDateTime.now()
            )
        );
    }
}
