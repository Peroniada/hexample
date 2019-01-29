package edu.perek.hexample.adapter.primary;

import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.primary.CypherService;
import edu.perek.hexample.adapter.primary.requests.SendMessageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
public class MessageEndpoint{

    private CypherService cypherService;

    public MessageEndpoint(CypherService cypherService) {
        this.cypherService = cypherService;
    }

    @PostMapping(path = "/send")
    public void sendMessage(@RequestBody SendMessageRequest request) {
        cypherService.sendMessage(request.message, request.recipient);
    }

    @GetMapping(path = "/getMessages")
    public List<Message> getEncryptedMessages() {
        return cypherService.getEncryptedMessages();
    }

    @PostMapping(path = "/decrypt")
    public Message decryptMessage(@RequestBody Message message) {
        return cypherService.decryptMessage(message);
    }

    @PostMapping(path = "/encrypt")
    public Message encryptMessage(Message message) {
        return cypherService.encryptMessage(message);
    }

    @GetMapping(path = "/decrypt-persisted")
    public Message decryptPersistedMessage(@RequestParam UUID uuid) {
        return cypherService.decryptPersistedMessage(uuid);
    }

    @PostMapping(path = "/persist")
    public void persistEncryptedMessage(@RequestBody Message message) {
        cypherService.persistEncryptedMessage(message);
    }
}
