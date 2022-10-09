package com.example.toolproject.services;

import com.example.toolproject.entities.Score;
import com.example.toolproject.repository.ScoreRepository;
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
        if (score.getId() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> e = scoreRepository.getScore(score.getId());

            if (e.isPresent()) {
                return score;
            } else {
                return scoreRepository.save(score);
            }
        }
    }

    public Score update(Score score) {
        if (score.getId() != null) {
            Optional<Score> e = scoreRepository.getScore(score.getId());

            if (e.isPresent()) {

                if (score.getStars() != null) {
                    e.get().setStars(score.getStars());
                }

                if (score.getMessageText() != null) {
                    e.get().setMessageText(score.getMessageText());
                }
                scoreRepository.save(e.get());
                return e.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Score> e = scoreRepository.getScore(id);
        if (e.isPresent()) {
            scoreRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}
