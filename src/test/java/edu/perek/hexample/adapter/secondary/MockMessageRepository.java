package edu.perek.hexample.adapter.secondary;

import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.secondary.MessageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class MockMessageRepository implements MessageRepository {

    private final List<Message> messages = new ArrayList<>();

    @Override
    public void save(Message message) {
        this.messages.add(message);
    }

    @Override
    public Message findById(UUID id) {
        return messages.stream()
                .filter(message -> message.getId().equals(id))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException("Entity not found"));
    }

    @Override
    public List<Message> findAll() {
        return this.messages;
    }


}
