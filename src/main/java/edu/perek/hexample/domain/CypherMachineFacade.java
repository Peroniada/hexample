package edu.perek.hexample.domain;

import edu.perek.hexample.domain.port.primary.CypherService;
import edu.perek.hexample.domain.port.secondary.MessageRepository;

public class CypherMachineFacade {
    private final EncryptMachine encryptMachine;
    private final DecryptMachine decryptMachine;
    private final CypherService cypherService;
    private final MessageRepository messageRepository;

    public CypherMachineFacade(EncryptMachine encryptMachine, DecryptMachine decryptMachine, CypherService cypherService, MessageRepository messageRepository) {
        this.encryptMachine = encryptMachine;
        this.decryptMachine = decryptMachine;
        this.cypherService = cypherService;
        this.messageRepository = messageRepository;

    }


}
