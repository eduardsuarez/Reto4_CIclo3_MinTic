/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.service;


import com.Reto4.Reto4.entity.Admininstrador;
import com.Reto4.Reto4.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public List<Admininstrador> getAdmins() {
        return repository.findAll();
    }

    public Admininstrador getAdminById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Admininstrador saveAdmin(Admininstrador admin) {
        return repository.save(admin);
    }
    
    public Admininstrador updateAdmin(Admininstrador admin){
        Admininstrador existeAdmin = getAdminById(admin.getId());
        existeAdmin.setId(admin.getId());
        //existeAdmin.setEmail(admin.getEmail());
        existeAdmin.setName(admin.getName());
        existeAdmin.setPassword(admin.getPassword());
        return repository.save(existeAdmin);
    }
    
    public void deleteAdmin(int id){
        repository.deleteById(id);
    }
}
