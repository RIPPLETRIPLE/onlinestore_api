package com.example.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler({EntityNotFoundException.class, EmptyArgumentException.class, NotUniqueFieldException.class})
    public ResponseEntity<ExceptionResponse> handleEntityNotFound(Exception exception) {
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleIncorrectAuthenticationData() {
        return new ResponseEntity<>(new ExceptionResponse("Incorrect login or password", HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
}
