package edu.perek.hexample;

import edu.perek.hexample.adapter.secondary.MapperMessageRepository;
import edu.perek.hexample.application.CypherServiceImpl;
import edu.perek.hexample.domain.CypherMachineFacade;
import edu.perek.hexample.domain.DecryptMachine;
import edu.perek.hexample.domain.EncryptMachine;
import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.primary.CypherService;
import edu.perek.hexample.domain.port.secondary.MessageRepository;
import edu.perek.hexample.domain.port.secondary.MessageSender;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HexampleConfiguration {

    private final MessageRepository mapperMessageRepository;
    private final MessageSender messageSender;

    @Autowired
    public HexampleConfiguration(MapperMessageRepository mapperMessageRepository, MessageSender messageSender) {
        this.mapperMessageRepository = mapperMessageRepository;
        this.messageSender = messageSender;
    }

    @Bean
    public CypherService cypherService() {
        return new CypherServiceImpl(cypherMachineFacade());
    }

    private CypherMachineFacade cypherMachineFacade() {
        EncryptMachine encryptMachine = (msg) -> new Message(msg.getId(), msg.getOwnerId(), StringUtils.reverse(msg.getContent()));
        DecryptMachine decryptMachine = (msg) -> new Message(msg.getId(), msg.getOwnerId(), StringUtils.reverse(msg.getContent()));
        return new CypherMachineFacade(encryptMachine, decryptMachine, mapperMessageRepository, messageSender);
    }

}
