package com.leonart.pedeai.infrastructure.web.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.Instant;

public class ErrorResponse {
    private final String timestamp;
    private final int status;
    private final String error;
    private final String message;


    public ErrorResponse(String message, HttpStatus status) {
        this.timestamp = Instant.now().toString();
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
    }

    public ErrorResponse(String timestamp, int status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public static ErrorResponse of(org.springframework.http.HttpStatus status, String message) {
        return new ErrorResponse(
                java.time.Instant.now().toString(),
                status.value(),
                status.getReasonPhrase(),
                message);
    }

    public String getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getMessage() { return message; }
}