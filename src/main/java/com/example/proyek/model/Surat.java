package com.example.proyek.model;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "surat")
public class Surat {
	private int id;
    private String nama_surat;
    private String deskripsi;
    private Timestamp created_at;

    public Surat() {
    }

    public Surat(int id, String nama_surat, String deskripsi, Timestamp created_at) {
        this.id = id;
        this.nama_surat = nama_surat;
        this.deskripsi = deskripsi;
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

    public String getNamaSurat() {
        return nama_surat;
    }
    public void setNamaSurat(String nama_surat) {
        this.nama_surat = nama_surat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public Timestamp getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}
