package com.rodinalmukhtaraulya.backend.controller;

import com.rodinalmukhtaraulya.backend.model.Score;
import com.rodinalmukhtaraulya.backend.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    // TODO: Buat endpoint GET /api/scores untuk mengambil semua score
    @GetMapping
    public ResponseEntity<List<Score>> getAllScores() {
        List<Score> scores = scoreService.getAllScores();
        return ResponseEntity.ok(scores);
    }

    // TODO: Buat endpoint GET /api/scores/leaderboard
    // Gunakan query parameter limit dengan default value 10
    @GetMapping("/leaderboard")
    public ResponseEntity<List<Score>> getLeaderboardByPoint(
            @RequestParam(defaultValue = "10") Integer limit) {

        List<Score> scores = scoreService.getLeaderboard(limit);
        return ResponseEntity.ok(scores);
    }

    // TODO: Buat endpoint GET /api/scores/above/{minValue}
    @GetMapping("/above/{minValue}")
    public ResponseEntity<List<Score>> getScoresAboveValue(
            @PathVariable Integer minValue) {

        List<Score> scores = scoreService.getScoreAboveValue(minValue);
        return ResponseEntity.ok(scores);
    }

    // TODO: Buat endpoint GET /api/scores/recent
    @GetMapping("/recent")
    public ResponseEntity<List<Score>> getRecentScores() {
        List<Score> scores = scoreService.getRecentScores();
        return ResponseEntity.ok(scores);
    }

    // TODO: Buat endpoint DELETE /api/scores/{scoreId}
    // Jika berhasil, berikan response bahwa score berhasil dihapus
    // Jika score tidak ditemukan, berikan status NOT_FOUND
    @DeleteMapping("/{scoreId}")
    public ResponseEntity<?> deleteScore(
            @PathVariable UUID scoreId) {

        try {
            scoreService.deleteScore(scoreId);

            return ResponseEntity.ok("Score berhasil dihapus");

        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}