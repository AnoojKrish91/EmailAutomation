package com.ak.emailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Controller
public class WeeklyEmail {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${email.to}")
    String to;

    @Value("${email.attachmentFolder}")
    String attachmentFolder;

    @Value("${email.attachmentFile}")
    String attachmentFile;

    @Value("${spring.mail.username}")
    String from;

    @Scheduled(cron = "0 30 18 * * 5") //Every Friday 18:30:00
    public void emailWithAttachmentSender() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("attachmentFile");
        helper.setText("Content of mail");

        FileSystemResource file
                = new FileSystemResource(new File(attachmentFolder+attachmentFile));
        helper.addAttachment("test.txt", file);

        emailSender.send(message);
        System.out.println("Mail sending");
    }

}

