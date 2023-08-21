package com.study.design_pattern._02_structural_patterns._10_facade._02_after;

public class Client {
    public static void main(String[] args) {
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost("127.0.0.1");
    
        EmailSender emailSender = new EmailSender(emailSettings);
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("hsb");
        emailMessage.setTo("sang");
        emailMessage.setSubject("오징어게임");
    }
}
