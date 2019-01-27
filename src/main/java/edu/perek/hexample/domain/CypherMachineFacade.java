package edu.perek.hexample.domain;

import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.secondary.MessageRepository;
import edu.perek.hexample.domain.port.secondary.MessageSender;

import java.util.List;
import java.util.UUID;

public class CypherMachineFacade {
    private final EncryptMachine encryptMachine;
    private final DecryptMachine decryptMachine;
    private final MessageRepository messageRepository;
    private final MessageSender messageSender;

    public CypherMachineFacade(EncryptMachine encryptMachine, DecryptMachine decryptMachine, MessageRepository messageRepository, MessageSender messageSender) {
        this.encryptMachine = encryptMachine;
        this.decryptMachine = decryptMachine;
        this.messageRepository = messageRepository;
        this.messageSender = messageSender;
    }

    public void persistEncryptedMessage(final Message message) {
        this.messageRepository.save(encrypt(message));
    }

    public Message getDecryptedMessage(final UUID id) {
        final Message message = this.messageRepository.findById(id);
        return decrypt(message);
    }

    public void sendEncryptedMessage(final Message message, final String recipient) {
        this.messageSender.send(encrypt(message), recipient);
    }

    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    public Message encrypt(final Message message) {
        return encryptMachine.cypher(message);
    }

    public Message decrypt(final Message message) {
        return decryptMachine.decypher(message);
    }

}
