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
@Table(name = "izin_keluar")
public class IK {
	private int id;
    private int id_user;
    private String keperluan;
    private Date tanggal;
    private Time jam;
    private Time jam_kembali;
    private int status;
    private Timestamp created_at;

    public IK() {
    }

    public IK(int id, int id_user, String keperluan, Date tanggal, Time jam, Time jam_kembali, int status, Timestamp created_at) {
        this.id = id;
        this.id_user = id_user;
        this.keperluan = keperluan;
        this.tanggal = tanggal;
        this.jam = jam;
        this.jam_kembali = jam_kembali;
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

    public String getKeperluan() {
        return keperluan;
    }
    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }
    
    public Date getTanggal() {
        return tanggal;
    }
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    public Time getJam() {
        return jam;
    }
    public void setJam(Time jam) {
        this.jam = jam;
    }
    
    public Time getJamKembali() {
        return jam_kembali;
    }
    public void setJamKembali(Time jam_kembali) {
        this.jam_kembali = jam_kembali;
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

