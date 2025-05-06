package com.example.rpgapi.service;

import com.example.rpgapi.model.CommandResponse;
import com.example.rpgapi.model.Player;
import com.example.rpgapi.model.Room;

import java.util.HashMap;
import java.util.Map;

public class GameService {
    private final Map<String, Player> players = new HashMap<>();
    private final Map<String, Room> rooms = new HashMap<>();

    public GameService() {
        Room room1 = new Room("Forest", "You are in a dark forest.", null, true);
        Room room2 = new Room("Temple", "You are inside an ancient temple.", null, false);
        room1.setExit("north", room2);
        room2.setExit("south", room1);
        rooms.put("Forest", room1);
        rooms.put("Temple", room2);
    }

    public CommandResponse processCommand(String playerId, String command) {
        Player player = players.computeIfAbsent(playerId, k -> new Player(playerId, rooms.get("Forest")));

        if (command.startsWith("move ")) {
            String dir = command.substring(5);
            Room next = player.getCurrentRoom().getExit(dir);
            if (next != null) {
                player.setCurrentRoom(next);
                return new CommandResponse("You move to: " + next.getName() + "\n" + next.getDescription());
            } else {
                return new CommandResponse("You can't go that way.");
            }
        } else if (command.equals("look")) {
            Room room = player.getCurrentRoom();
            return new CommandResponse("Location: " + room.getName() + "\n" + room.getDescription());
        } else {
            return new CommandResponse("Unknown command.");
        }
    }
}