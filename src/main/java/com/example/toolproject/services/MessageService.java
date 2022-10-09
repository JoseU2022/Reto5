package com.example.toolproject.services;

import com.example.toolproject.entities.Message;
import com.example.toolproject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());

            if (!e.isEmpty()) {
                return message;
            } else {
                return messageRepository.save(message);
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());

            if (!e.isEmpty()) {

                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Message> e = messageRepository.getMessage(id);
        if (!e.isEmpty()) {
            messageRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}
