package com.example.blog.controller;

import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        System.out.println("Hello");
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println(user);
        return userRepository.save(user);
    }
}
