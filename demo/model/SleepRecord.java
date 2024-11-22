package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class SleepRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // User ID

    private LocalDateTime waktuMulai; // Waktu mulai tidur
    private LocalDateTime waktuSelesai; // Waktu selesai tidur

    private LocalTime durasi; // Durasi tidur

    private int skor; // Skor tidur

    // Metode untuk menghitung durasi tidur
    public void hitungDurasi() {
        this.durasi = LocalTime.ofNanoOfDay(waktuSelesai.toLocalTime().toNanoOfDay() - waktuMulai.toLocalTime().toNanoOfDay());
    }

    // Metode untuk menghitung skor berdasarkan durasi
    public void hitungSkor() {
        this.skor = durasi.getHour() >= 7 ? 100 : 50; // Contoh logika sederhana
    }

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(LocalDateTime waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public LocalDateTime getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(LocalDateTime waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }

    public LocalTime getDurasi() {
        return durasi;
    }

    public void setDurasi(LocalTime durasi) {
        this.durasi = durasi;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }
}
