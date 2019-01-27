package edu.perek.hexample.domain.port.secondary;

import edu.perek.hexample.domain.model.Message;

import java.util.List;
import java.util.UUID;

public interface MessageRepository {

    void save(Message message);

    Message findById(UUID id);

    List<Message> findAll();
}
