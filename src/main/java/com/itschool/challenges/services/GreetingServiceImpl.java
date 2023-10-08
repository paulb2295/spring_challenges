package com.itschool.challenges.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public String getGreeting(String name) {
        return "Hello " + name + "!";
    }
}
