package com.itschool.challenges.controllers;

import com.itschool.challenges.models.User;
import com.itschool.challenges.services.EmailService;
import com.itschool.challenges.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    private EmailService emailService;

    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        emailService.sendEmail(createdUser.getEmail(), createdUser.getFirstName(), "http://localhost:8080/api/users/" + createdUser.getUserId());
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
