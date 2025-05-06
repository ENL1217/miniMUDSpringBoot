package com.example.rpgapi.controller;

import com.example.rpgapi.service.GameService;
import com.example.rpgapi.model.CommandRequest;
import com.example.rpgapi.model.CommandResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {
    private final GameService gameService = new GameService();

    @PostMapping("/command")
    public CommandResponse handleCommand(@RequestBody CommandRequest request) {
        return gameService.processCommand(request.getPlayerId(), request.getCommand());
    }
}