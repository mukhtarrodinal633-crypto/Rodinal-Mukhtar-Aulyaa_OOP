package com.rodinalmukhtaraulya.backend.controller;

import com.rodinalmukhtaraulya.backend.model.Score;
import com.rodinalmukhtaraulya.backend.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class HealthController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/{scoreId}")
    public ResponseEntity<?> getScoreById(@PathVariable UUID scoreId) {

        Optional<Score> score = scoreService.getScoreByID(scoreId);

        if (score.isPresent()) {
            return ResponseEntity.ok(score.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Score tidak ditemukan");
    }

    @PostMapping
    public ResponseEntity<?> createScore(@RequestBody Score score) {

        try {
            Score newScore = scoreService.createScore(score);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(newScore);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}