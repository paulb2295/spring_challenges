package com.itschool.challenges.services;

import com.itschool.challenges.models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;

    public String sendEmail(String recipient, String name, String link) {
        Email email = new Email();
        email.setSubject();
        email.setRecipient(recipient);
        email.setMsgBody(name, link);
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(email.getRecipient());
            mailMessage.setText(email.getMsgBody());
            mailMessage.setSubject(email.getSubject());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully!";
        } catch (Exception exception) {
            return "Error while Sending Mail!";
        }
    }
}
