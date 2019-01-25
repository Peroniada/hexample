package edu.perek.hexample.domain;

import edu.perek.hexample.domain.model.Message;

public interface EncryptMachine {
    Message cypher(Message message);
}
