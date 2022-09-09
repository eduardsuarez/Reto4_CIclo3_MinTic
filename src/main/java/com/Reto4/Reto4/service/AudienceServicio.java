/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.service;


import com.Reto4.Reto4.entity.Audience;
import com.Reto4.Reto4.repository.AudienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class AudienceServicio {

    @Autowired
    private AudienceRepository repository;

    public List<Audience> getAudiences() {
        return repository.findAll();
    }

    public Audience getAudienceById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Audience saveAudience(Audience audience) {
        return repository.save(audience);
    }
    
    public Audience updateAudience(Audience audience){
        Audience existeAudience = getAudienceById(audience.getId());
        //existeAudience.setId(audience.getId());
        existeAudience.setCapacity(audience.getCapacity());
        existeAudience.setName(audience.getName());
        existeAudience.setOwner(audience.getOwner());
        existeAudience.setDescription(audience.getDescription());
        return repository.save(existeAudience);
    }
    
    public void deleteAudience(int id){
        repository.deleteById(id);
        
    }
}
