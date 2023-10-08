package com.itschool.challenges.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    public static final String COMPANY_NAME = "THIS";
    public static final String COMPANY_EMAIL = "this@gmail.com";
    public static final String TEAM_NAME = "THIS TEAM";

    private String recipient;
    private String msgBody;
    private String subject;

    public void setMsgBody(String name, String link) {
        this.msgBody = "Hello " + name + "\n" +
                "We're excited to let you know that your account for " + COMPANY_NAME
                + " has been successfully created!\n" +
                "You can check your account here: " + link
                + " .Our support team is here to assist you. You can reach us at " +
                COMPANY_EMAIL + " or visit our help center!\n" +
                "Thank you for choosing" + COMPANY_NAME +
                ". We're thrilled to have you on board and can't wait to see what you'll achieve! \n"
                + "Warm regards,\n" + TEAM_NAME + "!";
    }

    public void setSubject() {
        this.subject = "Welcome to " + COMPANY_NAME +
                "! Your account has been created!";
    }
}
