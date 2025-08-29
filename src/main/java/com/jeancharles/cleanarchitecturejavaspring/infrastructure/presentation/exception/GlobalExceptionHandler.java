package com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.exception;

import com.jeancharles.cleanarchitecturejavaspring.core.domain.exception.UserAlreadyExistsException;
import com.jeancharles.cleanarchitecturejavaspring.infrastructure.presentation.dto.GlobalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<GlobalApiResponse<Void>> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new GlobalApiResponse<>(
                        HttpStatus.CONFLICT.value(),
                        e.getMessage(),
                        null,
                        LocalDateTime.now()
                )
        );
    }
}
