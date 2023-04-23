package com.example.Management.services;

import javax.swing.*;

public interface MailSender {
    void sendEmailMessage(String to, String subject, String text);
}
