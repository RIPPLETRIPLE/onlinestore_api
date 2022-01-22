package com.example.api.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExceptionResponse {
    private String message;
    private HttpStatus httpStatus;
    private String time;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public ExceptionResponse(String message, HttpStatus httpStatus, LocalDateTime now) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.time = dtf.format(now);
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getTime() {
        return time;
    }
}
