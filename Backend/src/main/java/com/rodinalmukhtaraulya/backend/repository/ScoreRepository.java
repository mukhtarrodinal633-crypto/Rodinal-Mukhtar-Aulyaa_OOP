package com.rodinalmukhtaraulya.backend.repository;

import com.rodinalmukhtaraulya.backend.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ScoreRepository extends JpaRepository<Score, UUID> {

    // TODO: Cari score yang memiliki point lebih besar dari minValue
    List<Score> findByPointGreaterThan(Integer minValue);

    // TODO: Cari semua score berdasarkan createdAt dari yang terbaru
    List<Score> findAllByOrderByCreatedAtDesc();

    // TODO: Cari score dengan point tertinggi sesuai limit
    @Query(value = "SELECT * FROM scores ORDER BY points DESC LIMIT ?1", nativeQuery = true)
    List<Score> findTopScores(Integer limit);
}