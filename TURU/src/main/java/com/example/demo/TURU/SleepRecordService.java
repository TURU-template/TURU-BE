package com.example.demo.TURU;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SleepRecordService {

    @Autowired
    private SleepRecordRepository sleepRecordRepository;

    public void addSleepRecord(Long userId, double hoursSlept, LocalDate date) {
        SleepRecord record = new SleepRecord();
        record.setUserId(userId);
        record.setSleepDurationInHours((int) hoursSlept);
        record.setDate(date);
        sleepRecordRepository.save(record); 
    }

    public int getWeeklySleepDuration(Long userId, LocalDate startDate) {
        LocalDate endDate = startDate.plusDays(6); 
        List<SleepRecord> records = sleepRecordRepository.findByUserIdAndDateBetween(userId, startDate, endDate);

        return records.stream()
                      .mapToInt(SleepRecord::getSleepDurationInHours)
                      .sum();
    }
}
