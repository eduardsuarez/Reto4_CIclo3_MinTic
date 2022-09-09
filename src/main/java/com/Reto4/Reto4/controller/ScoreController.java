/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.controller;


import com.Reto4.Reto4.entity.Score;
import com.Reto4.Reto4.service.ScoreService;
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
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @GetMapping("/all")
    public List<Score> findAllScores() {
        return service.getScores();
    }

    @GetMapping("/{id}")
    public Score findScoreId(@PathVariable int id) {
        return service.getScoreById(id);
    }

    @PostMapping("/save")
    public ResponseEntity addScore(@RequestBody Score score) {
        service.saveScore(score);
        return ResponseEntity.status(201).build();
    }
    @PutMapping("/update")
    public ResponseEntity updateScore(@RequestBody Score score){
        service.updateScore(score);
        return ResponseEntity.status(201).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteScoreId(@PathVariable int id){
        service.deleteScore(id);
        return ResponseEntity.status(204).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteScore(@RequestBody Score score){
        service.deleteScore(score.getIdScore());
        return ResponseEntity.status(204).build();
    }
}
