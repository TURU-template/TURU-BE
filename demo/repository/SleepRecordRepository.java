package com.example.demo.repository;

import com.example.demo.model.SleepRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SleepRecordRepository extends JpaRepository<SleepRecord, Long> {
    List<SleepRecord> findByUserIdAndWaktuMulaiBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);
}

