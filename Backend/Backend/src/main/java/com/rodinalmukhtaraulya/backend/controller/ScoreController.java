package com.rodinalmukhtaraulya.backend.controller;

import com.rodinalmukhtaraulya.backend.model.Score;
import com.rodinalmukhtaraulya.backend.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: tambah anotasi yang menandakan class ini merupakan REST API Controller
@RestController
// TODO: tambahkan anotasi untuk mapping api dengan "/api/scores"
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {
    // TODO: Tambahkan anotasi untuk melakukan Dependency Injection dari Instance yang sudah ada (ScoreService)
    @Autowired
    // TODO: Tambahkan private field untuk ScoreService
    private ScoreService scoreService;

}
        // TODO:
// 1. Beri anotasi yang sesuai untuk endpoint GET beserta endpoint yang sesuai
        public ResponseEntity<List<Score>> getAllScores() {
            // 2. Gunakan scoreService untuk memanggil getAllScores() dan simpan scores tersebut ke suatu variabel menggunakan List
            // 3. Kembalikan variabel berisi scores tersebut
        }
        // TODO:
// 1. Beri anotasi yang sesuai untuk endpoint GET beserta endpoint yang sesuai
        public  ResponseEntity<List<Score>> getLeaderboardByPoint(
	/* 2. tambahkan parameter'@RequestParam' dengan defaultValue 10
	   3. serta Integer limit */){
            // 4. Gunakan scoreService untuk memanggil getLeaderboard() dengan parameter yang sesuai
            //    dan simpan scores tersebut ke suatu variabel menggunakan List
            // 5. Kembalikan variabel berisi scores tersebut
        }
        // TODO:
// 1. Beri anotasi yang sesuai untuk endpoint GET beserta endpoint yang sesuai
        public ResponseEntity<List<Score>> getScoresAboveValue(
                /* 2. tambahkan '@PathVariable' untuk Integer minValue*/){
            // 3. Gunakan scoreService untuk memanggil getScoreAboveValue() dengan parameter yang sesuai
            //    dan simpan scores tersebut ke suatu variabel menggunakan List
            // 4. Kembalikan variabel berisi scores tersebut
        }
        // TODO:
// 1. Beri anotasi yang sesuai untuk endpoint GET beserta endpoint yang sesuai
        public ResponseEntity<List<Score>> getRecentScores(){
            // 2. Gunakan scoreService untuk memanggil getRecentScores() dengan parameter yang sesuai
            //    dan simpan scores tersebut ke suatu variabel menggunakan List
            // 3. Kembalikan variabel berisi scores tersebut
        }
        // TODO:
// 1. Beri anotasi yang sesuai untuk endpoint DELETE beserta endpoint yang sesuai
        public  ResponseEntity<?> deleteScore(
                /* 2. tambahkan '@PathVariable' untuk scoreId*/){
            // 3. buat try-catch block
            // pada try block:
            //  gunakan scoreService untuk memanggil deleteScore() dengan parameter yang sesuai
            //  kembalikan respons untuk menandakan score berhasil dihapus
            // pada catch block:
            //  kembalikan response error dengan status NOT_FOUND beserta body error yang sesuai
        }
