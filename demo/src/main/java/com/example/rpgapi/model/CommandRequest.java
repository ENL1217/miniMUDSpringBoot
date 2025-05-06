package com.example.rpgapi.model;

public class CommandRequest {
    private String playerId;
    private String command;

    public String getPlayerId() { return playerId; }
    public void setPlayerId(String playerId) { this.playerId = playerId; }

    public String getCommand() { return command; }
    public void setCommand(String command) { this.command = command; }
}