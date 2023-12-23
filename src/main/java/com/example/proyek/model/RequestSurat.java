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
@Table(name = "request_surat")
public class RequestSurat {
	private int id;
    private int id_user;
    private int id_surat;
    private String keperluan;
    private int status;
    private Timestamp created_at;

    public RequestSurat() {
    }

    public RequestSurat(int id, int id_user, int id_surat, String keperluan, int status, Timestamp created_at) {
        this.id = id;
        this.id_user = id_user;
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
    public int getIdSurat() {
        return id_surat;
    }
    public void setIdSurat(int id_surat) {
        this.id_surat = id_surat;
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
