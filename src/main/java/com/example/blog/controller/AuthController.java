package com.example.blog.controller;

import com.example.blog.service.AuthResponse;
import com.example.blog.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestParam String name, @RequestParam String email,@RequestParam String username,
            @RequestParam String password) {
        return ResponseEntity.ok(authService.signUp(name, email,username, password));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestParam String email, @RequestParam String password) {
        System.out.printf(email,password);
        return ResponseEntity.ok(authService.signIn(email, password));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("{\"message\": \"You have been logged out successfully\"}");
    }
}
