package edu.perek.hexample.domain.port.primary;

import edu.perek.hexample.domain.model.Message;

public interface CypherService {
    void sendMesage(Message message);

    void persistMessage (Message message);
}
