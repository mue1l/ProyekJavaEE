package com.example.proyek.model;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruangan")
public class Ruangan {
	private int id;
    private String nama_ruangan;
    private String deskripsi_ruangan;
    private Timestamp created_at;

    public Ruangan() {
    }

    public Ruangan(int id, String nama_ruangan, String deskripsi_ruangan, Timestamp created_at) {
        this.id = id;
        this.nama_ruangan = nama_ruangan;
        this.deskripsi_ruangan = deskripsi_ruangan;
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

    public String getNamaRuangan() {
        return nama_ruangan;
    }
    public void setNamaRuangan(String nama_ruangan) {
        this.nama_ruangan = nama_ruangan;
    }

    public String getDeskripsiRuangan() {
        return deskripsi_ruangan;
    }
    public void setDeskripsiRuangan(String deskripsi_ruangan) {
        this.deskripsi_ruangan = deskripsi_ruangan;
    }
    
    public Timestamp getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}