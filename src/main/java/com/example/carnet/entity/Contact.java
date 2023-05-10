package com.example.carnet.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Contact () {

    }

    public Contact(String username, String email, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

//    public Contact(long id, String username, String email, String phoneNumber) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
