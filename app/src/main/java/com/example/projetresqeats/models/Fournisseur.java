package com.example.projetresqeats.models;

public class Fournisseur {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String adresse;
    private String role;
    private String mission;


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAdresse() {
        return adresse;
    }

    public String getRole() {
        return role;
    }
    public  void  setUsername(){
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
