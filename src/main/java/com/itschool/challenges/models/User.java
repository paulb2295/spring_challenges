package com.itschool.challenges.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class User {

    private UUID userId;
    @Size(min = 3, message = "First name should be longer than 2 characters!")
    private String firstName;
    @Size(min = 3, message = "Last name should be longer than 2 characters!")
    private String lastName;
    @Email
    private String email;
    private LocalDateTime accountCreatedIn;

}
