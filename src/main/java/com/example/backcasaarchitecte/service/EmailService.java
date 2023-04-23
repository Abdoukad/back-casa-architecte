package com.example.backcasaarchitecte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Classe de service pour gérer l'envoi d'e-mails.
 * Utilise JavaMailSender pour envoyer des e-mails.
 */
@Service
public class EmailService {

    private final JavaMailSender mailSender;

    /**
     * Constructeur pour l'injection de dépendance de JavaMailSender.
     *
     * @param mailSender l'instance de JavaMailSender à utiliser pour envoyer des e-mails
     */
    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Envoie un e-mail avec les paramètres fournis.
     *
     * @param to      l'adresse e-mail du destinataire
     * @param subject le sujet de l'e-mail
     * @param text    le contenu de l'e-mail
     */
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("casa-architecte@outlook.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
