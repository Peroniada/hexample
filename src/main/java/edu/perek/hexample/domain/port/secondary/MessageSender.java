package edu.perek.hexample.domain.port.secondary;

import edu.perek.hexample.domain.model.Message;

public interface MessageSender {
    void send(Message message);
}
