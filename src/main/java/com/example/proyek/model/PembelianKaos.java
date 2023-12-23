package com.example.proyek.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pembelian_kaos")
public class PembelianKaos {
	private int id;
    private int id_user;
    private int ukuran;
    private int jumlah;
    private double total;
    private int status;
    private Timestamp created_at;

    public PembelianKaos() {
    }

    public PembelianKaos(int id, int id_user, int ukuran, int status, double total, int jumlah, Timestamp created_at) {
        this.id = id;
        this.id_user = id_user;
        this.ukuran = ukuran;
        this.jumlah = jumlah;
        this.status = status;
        this.total = total;
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

    public int getUkuran() {
        return ukuran;
    }
    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
    }
    
    public int getJumlah() {
        return jumlah;
    }
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    
    public Timestamp getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}

