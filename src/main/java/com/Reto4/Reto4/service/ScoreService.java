/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.service;

import com.Reto4.Reto4.entity.Score;
import com.Reto4.Reto4.repository.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository repository;
    
    public List<Score> getScores() {
        return repository.findAll();
    }
    
    public Score getScoreById(int id) {
        return repository.findById(id).orElse(null);
    }
    
    public Score saveScore(Score score) {
        return repository.save(score);
    }
    
    public Score updateScore(Score score) {
        Score existeScore = getScoreById(score.getIdScore());
        existeScore.setIdScore(score.getIdScore());
        existeScore.setQualification(score.getQualification());
        existeScore.setMessageText(score.getMessageText());
        existeScore.setIdReservation(score.getIdReservation());
        return repository.save(existeScore);
    }

    public void deleteScore(int id) {
        repository.deleteById(id);
    }
}
