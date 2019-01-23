package edu.perek.hexample.adapter.primary;

import edu.perek.hexample.domain.CypherMachineFacade;
import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.primary.CypherService;
import edu.perek.hexample.domain.port.primary.requests.SendMessageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
public class MessageEndpoint implements CypherService {

    private CypherMachineFacade machineFacade;

    public MessageEndpoint(CypherMachineFacade machineFacade) {
        this.machineFacade = machineFacade;
    }

    @Override
    @PostMapping(path = "/send")
    public void sendMessage(@RequestBody SendMessageRequest request) {
        machineFacade.sendEncryptedMessage(request.message, request.recipient);
    }

    @Override
    @GetMapping(path = "/getMessages")
    public List<Message> getEncryptedMessages() {
        return machineFacade.findAllMessages();
    }

    @Override
    @PostMapping(path = "/decrypt")
    public Message decryptMessage(@RequestBody Message message) {
        return machineFacade.decrypt(message);
    }

    @Override
    @PostMapping(path = "/encrypt")
    public Message encryptMessage(Message message) {
        return machineFacade.encrypt(message);
    }

    @Override
    @GetMapping(path = "/decrypt-persisted")
    public Message decryptPersistedMessage(@PathVariable UUID uuid) {
        return machineFacade.getDecryptedMessage(uuid);
    }

    @Override
    @GetMapping(path = "/persist")
    public void persistEncryptedMessage(@RequestBody Message message) {
        machineFacade.persistEncryptedMessage(message);
    }
}
