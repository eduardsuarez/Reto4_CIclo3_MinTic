/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.service;

import com.Reto4.Reto4.entity.Client;
import com.Reto4.Reto4.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;
    
    public List<Client> getClients() {
        return repository.findAll();
    }
    
    public Client getClientById(int id) {
        return repository.findById(id).orElse(null);
    }
    
    public Client saveClient(Client client) {
        return repository.save(client);
    }
    
    public Client updateClient(Client client) {
        Client existeClient = getClientById(client.getIdClient());
        //existeClient.setIdClient(client.getIdClient());
        existeClient.setAge(client.getAge());
        //existeClient.setEmail(client.getEmail());
        existeClient.setName(client.getName());
        existeClient.setPassword(client.getPassword());
        return repository.save(existeClient);
    }
    
    public void deleteClient(int id) {
        repository.deleteById(id);
    }
    
}
