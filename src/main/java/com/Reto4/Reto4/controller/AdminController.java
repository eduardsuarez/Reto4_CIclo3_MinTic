/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.controller;

import com.Reto4.Reto4.entity.Admininstrador;
import com.Reto4.Reto4.service.AdminService;
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
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/all")
    public List<Admininstrador> findAllAdmins() {
        return service.getAdmins();
    }

    @GetMapping("/{id}")
    public Admininstrador findAdminId(@PathVariable int id) {
        return service.getAdminById(id);
    }

    @PostMapping("/save")
    public ResponseEntity addAdmin(@RequestBody Admininstrador admin) {
        service.saveAdmin(admin);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateAdmin(@RequestBody Admininstrador admin) {
        service.updateAdmin(admin);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdminId(@PathVariable int id) {
        service.deleteAdmin(id);
        return ResponseEntity.status(204).build();

    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteAdmin(@RequestBody Admininstrador admininstrador){
        service.deleteAdmin(admininstrador.getId());
        return ResponseEntity.status(204).build();
    }

}
