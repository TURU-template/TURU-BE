package com.example.demo.controller;

import com.example.demo.model.SleepRecord;
import com.example.demo.service.SleepRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sleep")
public class SleepRecordController {

    @Autowired
    private SleepRecordService service;

    @PostMapping("/add")
    public ResponseEntity<String> addSleepRecord(
            @RequestParam Long userId,
            @RequestParam String waktuMulai,
            @RequestParam String waktuSelesai) {
        // Parsing input waktuMulai dan waktuSelesai
        LocalDateTime start = LocalDateTime.parse(waktuMulai);
        LocalDateTime end = LocalDateTime.parse(waktuSelesai);

        service.addSleepRecord(userId, start, end);
        return ResponseEntity.ok("Data tidur berhasil ditambahkan!");
    }

    @GetMapping("/statistics")
    public List<SleepRecord> getWeeklySleepStatistics(@RequestParam Long userId) {
        return service.getSleepRecordsForLast7Days(userId);
    }
}
