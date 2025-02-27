package com.example.messageInterface.Service;

import com.example.messageInterface.Model.Message;
import com.example.messageInterface.Repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
        message.setDate(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public Message createMessage(String content, String author) {
        Message message = new Message();
        message.setContent(content);
        message.setAuthor(author);
        message.setDate(LocalDateTime.now());
        return messageRepository.save(message);
    }
}
