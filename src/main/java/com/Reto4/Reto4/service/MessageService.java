/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.service;

import com.Reto4.Reto4.entity.Message;
import com.Reto4.Reto4.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository repository;
    
    public List<Message> getMessages() {
        return repository.findAll();
    }
    
    public Message getMessageById(int id) {
        return repository.findById(id).orElse(null);
    }
    
    public Message saveMessage(Message message) {
        return repository.save(message);
    }

    public Message updateMessage(Message message) {
        Message existeMessage = getMessageById(message.getIdMessage());
        existeMessage.setIdMessage(message.getIdMessage());
        existeMessage.setMessageText(message.getMessageText());
        
        return repository.save(existeMessage);
    }
    
    public void deleteMessage(int id) {
        repository.deleteById(id);
    }
    
}
