package com.study.design_pattern._02_structural_patterns._10_facade._02_after;

import java.util.Properties;

public class EmailSender {
    private EmailSettings emailSettings;
    
    public EmailSender(EmailSettings emailSettings) {
        this.emailSettings = emailSettings;
    }
    
    public void sendEmail(EmailMessage emailMessage) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", emailSettings.getHost());
    }
}
