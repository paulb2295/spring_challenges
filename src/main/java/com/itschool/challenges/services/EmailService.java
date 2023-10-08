package com.itschool.challenges.services;

import com.itschool.challenges.models.Email;

public interface EmailService {

    String sendEmail(String recipient, String name, String link);
}
