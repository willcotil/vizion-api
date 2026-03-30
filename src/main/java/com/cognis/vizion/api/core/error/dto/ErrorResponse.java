package com.cognis.vizion.api.core.error.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ErrorResponse {
    private String error;
    private String message;
    private int status;
    private String timestamp;
    private String path;

    public ErrorResponse(String error, String message, int status, String path) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.timestamp = OffsetDateTime.now().toString();
        this.path = path;
    }

}