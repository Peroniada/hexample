package edu.perek.hexample.adapter.secondary;

import edu.perek.hexample.adapter.secondary.model.JPAMessage;
import edu.perek.hexample.domain.model.Message;
import edu.perek.hexample.domain.port.secondary.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MapperMessageRepository implements MessageRepository {

    private JpaMessageRepository jpaRepository;

    @Autowired
    public MapperMessageRepository(JpaMessageRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Message message) {
        this.jpaRepository.save(toJpaMassage(message));
    }

    @Override
    public Message findById(UUID id) {
        return toMessage(this.jpaRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Entity not found")));
    }

    @Override
    public List<Message> findAll() {
        return toMessageList(this.jpaRepository.findAll());
    }

    private Message toMessage(JPAMessage messagePM) {
        return Message.builder().id(messagePM.id).ownerId(messagePM.ownerId).content(messagePM.content).build();
    }

    private List<Message> toMessageList(List<JPAMessage> messagePMS) {
        return messagePMS.stream().map(this::toMessage).collect(Collectors.toList());
    }

    private JPAMessage toJpaMassage(Message message) {
        return new JPAMessage(message.getId(), message.getOwnerId(), message.getContent());
    }
}
