package edu.perek.hexample.adapter.secondary;

import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.secondary.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageSender implements MessageSender {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailMessageSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void send(Message message, String recipient) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipient);
        mailMessage.setSubject("secret message");
        mailMessage.setText(message.getContent());
        emailSender.send(mailMessage);
    }
}
