package com.reto3.reto3.servicio;

import com.reto3.reto3.entidad.Score;
import com.reto3.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreFound = getScore(score.getIdScore());
            if (scoreFound.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }
}