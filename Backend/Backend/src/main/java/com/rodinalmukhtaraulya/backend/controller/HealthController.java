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

// TODO: tambah anotasi yang menandakan class ini merupakan REST API Controller
@RestController
// TODO: tambahkan anotasi untuk mapping api dengan "/api/scores"
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class  HealthController {
    // TODO: Tambahkan anotasi untuk melakukan Dependency Injection dari Instance yang sudah ada (ScoreService)
    @Autowired
    // TODO: Tambahkan private field untuk ScoreService
    private ScoreService scoreService;

    // GET /api/scores/{scoreId}
    // TODO: tambahkan anotasi untuk maps HTTP GET ke method ini dengan path "/{scoreId}"
    @GetMapping("/{scoreId}")
    public ResponseEntity<?> getScoreById(/* TODO: tambahkan @PathVariable untuk scoreId di sini */ @PathVariable UUID scoreId) {
        // TODO: buat variabel score untuk menyimpan score yang didapat dari scoreService
        // hint: gunakan tipe data Optional
        // hint: gunakan method getScoreById dari scoreService dengan parameter yang sesuai
        Optional<Score> score = scoreService.getScoreByID(scoreId);

        // cek apakah variabel score ada isinya dengan isPresent()
        // jika ya kembalikan score yang dipost (hint: kembalikan `ResponseEntity.ok(score.get())`)
        if (score.isPresent()) {
            return ResponseEntity.ok(score.get());
        }

        // jika tidak maka kembalikan status NOT_FOUND dengan keterangan body error yang sesuai
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Score tidak ditemukan");
    }
    //POST /api/scores
    // TODO: Tambahkan anotsi untuk maps HTTP POST ke method ini
    @PostMapping
    public ResponseEntity<?> createScore(/* TODO: berikan @RequestBody untuk bind JSON body dari request ke object score di sini */ @RequestBody Score score){
        try{
            // TODO: Buat instance score baru menggunakakan scoreService dengan data yang ada dari parameter
            Score newScore = scoreService.createScore(score);
            // TODO: kembalikan response data score baru dengan status CREATED
            return ResponseEntity.status(HttpStatus.CREATED).body(newScore);
        } catch (RuntimeException e){
            // TODO: kembalikan response error dengan status BAD_REQUEST beserta body error yang sesuai
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}