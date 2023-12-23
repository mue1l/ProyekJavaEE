package com.example.proyek.model;

import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_ruangan")
public class BookingRuangan {
	private int id;
    private int id_user;
    private int id_ruangan;
    private int waktu;
    private Date tanggal;
    private Time jam;
    private String keperluan;
    private int status;
    private Timestamp created_at;

    public BookingRuangan() {
    }

    public BookingRuangan(int id, int id_user, int id_ruangan, Date tanggal, Time jam, int waktu, String keperluan, int status, Timestamp created_at) {
        this.id = id;
        this.id_user = id_user;
        this.id_ruangan = id_ruangan;
        this.tanggal = tanggal;
        this.jam = jam;
        this.waktu = waktu;
        this.keperluan = keperluan;
        this.status = status;
        this.created_at = created_at;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return id_user;
    }
    public void setIdUser(int id_user) {
        this.id_user = id_user;
    }

    public int getIdRuangan() {
        return id_ruangan;
    }
    public void setIdRuangan(int id_ruangan) {
        this.id_ruangan = id_ruangan;
    }
    
    public Date getTanggal() {
        return tanggal;
    }
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    public Time getjam() {
        return jam;
    }
    public void setJam(Time jam) {
        this.jam = jam;
    }
    public int getWaktu() {
        return waktu;
    }
    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }
    
    public String getKeperluan() {
        return keperluan;
    }
    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
    public Timestamp getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}
