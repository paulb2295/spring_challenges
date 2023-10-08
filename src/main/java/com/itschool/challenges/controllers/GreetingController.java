package com.itschool.challenges.controllers;

import com.itschool.challenges.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet/{name}")
    public ResponseEntity<String> greet(@PathVariable String name) {
        return ResponseEntity.ok(greetingService.getGreeting(name));
    }
}
