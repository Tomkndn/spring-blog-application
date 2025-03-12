package com.example.blog.controller;

import com.example.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody Map<String, String> request) {
        return authService.signup(request.get("username"), request.get("password"),request.get("name"),request.get("email"));
    }

    @PostMapping("/signin")
    public String signin(@RequestBody Map<String, String> request) {
        return authService.signin(request.get("email"), request.get("password"));
    }
}
