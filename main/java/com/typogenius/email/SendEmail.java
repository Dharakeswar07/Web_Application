package com.typogenius.email;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    public static void main(String[] args) {
        String to = "dharakeswar@gmail.com"; //change accordingly
        String from = "TypoGenius07@gmail.com"; //change accordingly
        String senderName = "Typo Genius"; // Sender's name

        String host = "smtp.gmail.com";

        // Gmail username and password
        final String username = "TypoGenius07@gmail.com"; // change accordingly
        final String password = "xrwbkyjwozurgdii"; // change accordingly

        // Get the session object
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        // Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            
            // Set From header with sender's name and email address
            message.setFrom(new InternetAddress(from, senderName));
            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Ping");
            message.setText("Hello, this is an example of sending email");
            // Send message
            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

