package com.example.api.exception;

public class EmptyArgumentException extends RuntimeException{
    public EmptyArgumentException(String message) {
        super(String.format("Argument %s is empty", message));
    }
}
