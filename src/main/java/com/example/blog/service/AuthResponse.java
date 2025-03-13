package com.example.blog.service;

public class AuthResponse {
    private String message;
    private Long id;
    private String email;
    private String token;

    public AuthResponse(String message, Long id, String email, String token) {
        this.message = message;
        this.id = id;
        this.email = email;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
}
