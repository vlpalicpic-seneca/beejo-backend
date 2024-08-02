package com.example.beejo;

import com.example.beejo.User;

public class UserResponse {
    private String message;
    private User user;

    // Constructors, getters, and setters

    public UserResponse(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
