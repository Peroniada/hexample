package edu.perek.hexample.domain.port.primary.requests;

import edu.perek.hexample.domain.model.Message;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SendMessageRequest {
    public Message message;
    public String recipient;
}