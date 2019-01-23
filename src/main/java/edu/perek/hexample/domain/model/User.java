package edu.perek.hexample.domain.model;

import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private List<Message> messages;

    public User(UUID id, String name, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.messages = messages;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
