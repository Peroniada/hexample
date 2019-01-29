package edu.perek.hexample.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode
@Builder
@NoArgsConstructor
public class Message {
    private UUID id;
    private UUID ownerId;
    private String content;

    public Message(UUID id, UUID ownerId, String content) {
        this.id = id;
        this.ownerId = ownerId;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public String getContent() {
        return content;
    }
}
