package com.example.api.exception;

public class NotUniqueFieldException extends RuntimeException{
    public NotUniqueFieldException(String message) {
        super(String.format("Field %s not unique",message));
    }
}
