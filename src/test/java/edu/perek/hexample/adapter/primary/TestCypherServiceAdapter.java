package edu.perek.hexample.adapter.primary;

import edu.perek.hexample.adapter.secondary.MockMessageRepository;
import edu.perek.hexample.adapter.secondary.MockMessageSender;
import edu.perek.hexample.domain.CypherMachineFacade;
import edu.perek.hexample.domain.DecryptMachine;
import edu.perek.hexample.domain.EncryptMachine;
import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.primary.CypherService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCypherServiceAdapter implements CypherService {

    private static CypherMachineFacade cypherMachineFacade;

    @Before
    public void setup() {

        EncryptMachine encryptMachine = this::reverseString;
        DecryptMachine decryptMachine = this::reverseString;

        cypherMachineFacade = new CypherMachineFacade(encryptMachine, decryptMachine, new MockMessageRepository(), new MockMessageSender());
    }

    @Override
    public void sendMessage(Message message, String recipient) {
        cypherMachineFacade.sendEncryptedMessage(message, recipient);
    }

    @Override
    public List<Message> getEncryptedMessages() {
        return cypherMachineFacade.findAllMessages();
    }

    @Override
    public Message decryptMessage(Message message) {
        return cypherMachineFacade.decrypt(message);
    }

    @Override
    public Message encryptMessage(Message message) {
        return cypherMachineFacade.encrypt(message);
    }

    @Override
    public Message decryptPersistedMessage(UUID uuid) {
        return cypherMachineFacade.getDecryptedMessage(uuid);
    }

    @Override
    public void persistEncryptedMessage(Message message) {
        cypherMachineFacade.persistEncryptedMessage(message);
    }

    @Test
    public void should_encrypt_message() {
        //given
        Message message = new Message(randomUUID(), randomUUID(), "123");
        //when
        cypherMachineFacade.persistEncryptedMessage(message);
        //then
        Message encryptedMessage = cypherMachineFacade.findAllMessages().get(0);
        assertThat(encryptedMessage.getContent()).isEqualTo("321");
    }

    @Test
    public void should_decrypt_persisted_message() {
        //given
        final String content = "123";
        Message message = new Message(randomUUID(), randomUUID(), content);
        cypherMachineFacade.persistEncryptedMessage(message);
        //when
        final Message decryptedMessage = cypherMachineFacade.getDecryptedMessage(message.getId());
        //then
        assertThat(decryptedMessage.getContent()).isEqualTo(content);
    }

    @Test
    public void should_send_encrypted_message() {
        //given
        final Message message = new Message(randomUUID(), randomUUID(), "to send");
        //when
        cypherMachineFacade.sendEncryptedMessage(message, "test@gmail.com");
        //then

    }

    private UUID randomUUID() {
        return UUID.randomUUID();
    }

    private Message reverseString(Message msg) {
        return new Message(msg.getId(), msg.getOwnerId(), StringUtils.reverse(msg.getContent()));
    }
}
