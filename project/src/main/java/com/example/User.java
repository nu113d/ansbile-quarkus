package com.example;


import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class User {

    private String userID;

    public User() {
        this.userID = UUID.randomUUID().toString();
        
    }

    public String getUserID() {
        return this.userID;
    }
}