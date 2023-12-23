package com.example.proyek.model; // Adjust the package name

public class SessionData {
    private Integer idUser;

    // Default constructor
    public SessionData() {
        // Default constructor with no parameters
    }

    // Constructor with Integer parameter
    public SessionData(Integer idUser) {
        this.idUser = idUser;
    }

    // Getter and Setter methods
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
