package edu.perek.hexample.adapter.secondary;

import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.secondary.MessageSender;
import org.springframework.stereotype.Component;

public class MockMessageSender implements MessageSender {

    @Override
    public void send(Message message, String recipient) {
        System.out.println("Message " + message.getId() + " was sent to " + recipient);
    }
}
