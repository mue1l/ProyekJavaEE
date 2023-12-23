package com.example.proyek.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user") // Corrected table name
public class User {
    private int id;
    private String nama;
    private String nim;
    private BigInteger no_telepon;
    private BigInteger no_ktp;
    private String username;
    private String password;

    public User() {
    }

    public User(int id, String username, String password, BigInteger no_telepon, String nim, BigInteger no_ktp, String nama) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.no_telepon = no_telepon;
        this.nama = nama;
        this.no_ktp = no_ktp;
        this.nim = nim;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public BigInteger getNoTelepon() {
        return no_telepon;
    }
    public void setNoTelepon(BigInteger no_telepon) {
        this.no_telepon = no_telepon;
    }
    
    public BigInteger getNoKtp() {
        return no_ktp;
    }
    public void setNoKtp(BigInteger no_ktp) {
        this.no_ktp = no_ktp;
    }
    
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
}
