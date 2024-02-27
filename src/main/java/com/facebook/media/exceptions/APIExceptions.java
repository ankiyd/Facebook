package com.facebook.media.exceptions;

import org.springframework.http.HttpStatus;

public class APIExceptions extends RuntimeException{
    private HttpStatus status;
    private String message;

    public APIExceptions(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public APIExceptions(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

