package edu.perek.hexample.adapter.secondary.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class JPAMessage extends MessagePM {
    @Id
    public UUID id;
    public UUID ownerId;
    public String content;
}
