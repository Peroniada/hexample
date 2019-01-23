package edu.perek.hexample.domain.port.primary;

import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.primary.requests.SendMessageRequest;

import java.util.List;
import java.util.UUID;

public interface CypherService {
    void sendMessage(SendMessageRequest request);

    List<Message> getEncryptedMessages();

    Message decryptMessage(Message message);

    Message encryptMessage(Message message);

    Message decryptPersistedMessage(UUID uuid);

    void persistEncryptedMessage(Message message);
}
