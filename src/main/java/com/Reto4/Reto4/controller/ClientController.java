/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.controller;

import com.Reto4.Reto4.entity.Client;
import com.Reto4.Reto4.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduar
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> findAllClients() {
        return service.getClients();
    }

    @GetMapping("/{id}")
    public Client findClientId(@PathVariable int id) {
        return service.getClientById(id);
    }

    @PostMapping("/save")
    public ResponseEntity addClient(@RequestBody Client client) {
        service.saveClient(client);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client client) {
        service.updateClient(client);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClientId(@PathVariable int id) {
        service.deleteClient(id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteClient(@RequestBody Client client) {
        service.deleteClient(client.getIdClient());
        return ResponseEntity.status(204).build();
    }

}
