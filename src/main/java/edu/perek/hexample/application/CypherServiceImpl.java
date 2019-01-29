package edu.perek.hexample.application;

import edu.perek.hexample.domain.CypherMachineFacade;
import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.primary.CypherService;

import java.util.List;
import java.util.UUID;

public class CypherServiceImpl implements CypherService {

    private final CypherMachineFacade machineFacade;

    public CypherServiceImpl(CypherMachineFacade machineFacade) {
        this.machineFacade = machineFacade;
    }

    @Override
    public void sendMessage(Message message, String recipient) {
        machineFacade.sendEncryptedMessage(message, recipient);
    }

    @Override
    public List<Message> getEncryptedMessages() {
        return machineFacade.findAllMessages();
    }

    @Override
    public Message decryptMessage( Message message) {
        return machineFacade.decrypt(message);
    }

    @Override
    public Message encryptMessage(Message message) {
        return machineFacade.encrypt(message);
    }

    @Override
    public Message decryptPersistedMessage(UUID uuid) {
        return machineFacade.getDecryptedMessage(uuid);
    }

    @Override
    public void persistEncryptedMessage(Message message) {
        machineFacade.persistEncryptedMessage(message);
    }
}
