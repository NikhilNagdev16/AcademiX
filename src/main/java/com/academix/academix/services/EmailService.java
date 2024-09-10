package com.academix.academix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendCredentials(String to, String username, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your AcademiX Credentials");
        message.setText(String.format("Hello,\n\nHere are your credentials for AcademiX:\n\nUsername: %s\nPassword: %s\n\nPlease keep this information secure.\n\nBest regards,\nAcademiX Team",
                username, password));

        emailSender.send(message);
    }
}