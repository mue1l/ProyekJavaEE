package com.example.proyek.model;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "izin_bermalam")
public class IB {
	@ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "id_user", insertable = false, updatable = false)
    private int id_user;
    private String keperluan;
    private Date tanggal;
    private Date kembali;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time jam;
    private int status;
    private Timestamp created_at;

    public IB() {
    }

    public IB(int id, int id_user, String keperluan, Date tanggal, Date kembali, Time jam, int status, Timestamp created_at) {
        this.id = id;
        this.id_user = id_user;
        this.keperluan = keperluan;
        this.tanggal = tanggal;
        this.kembali = kembali;
        this.jam = jam;
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
    public Date getKembali() {
        return kembali;
    }
    public void setKembali(Date kembali) {
        this.kembali = kembali;
    }
    
    public Time getJam() {
        return jam;
    }
    public void setJam(Time jam) {
        this.jam = jam;
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
