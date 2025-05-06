package com.example.rpgapi.model;

public class CommandResponse {
    private String message;

    public CommandResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}