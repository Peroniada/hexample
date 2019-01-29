package edu.perek.hexample.adapter.primary.requests;

import edu.perek.hexample.domain.model.Message;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SendMessageRequest {
    public Message message;
    public String recipient;
}