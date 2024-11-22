package com.example.demo.service;

import com.example.demo.model.SleepRecord;
import com.example.demo.repository.SleepRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SleepRecordService {

    @Autowired
    private SleepRecordRepository sleepRecordRepository;

    // Menambah data rekaman tidur
    public void addSleepRecord(Long userId, LocalDateTime waktuMulai, LocalDateTime waktuSelesai) {
        SleepRecord record = new SleepRecord();
        record.setUserId(userId);
        record.setWaktuMulai(waktuMulai);
        record.setWaktuSelesai(waktuSelesai);
        record.hitungDurasi(); // Hitung durasi otomatis
        record.hitungSkor(); // Hitung skor otomatis
        sleepRecordRepository.save(record);
    }

    // Mengambil data rekaman tidur dalam 7 hari terakhir
    public List<SleepRecord> getSleepRecordsForLast7Days(Long userId) {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(6); // 6 hari yang lalu
        LocalDateTime today = LocalDateTime.now(); // Hari ini
        return sleepRecordRepository.findByUserIdAndWaktuMulaiBetween(userId, sevenDaysAgo, today); // Query sesuai
    }
}
