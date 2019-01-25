package edu.perek.hexample.domain;

import edu.perek.hexample.domain.model.Message;

public interface DecryptMachine {
    Message decypher(Message message);
}
