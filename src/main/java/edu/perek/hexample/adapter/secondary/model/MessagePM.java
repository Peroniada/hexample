package edu.perek.hexample.adapter.secondary.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public abstract class MessagePM {
    public UUID id;
    public UUID ownerId;
    public String content;
}
