package com.devansh.MailApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService{


    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(MailEntity mailEntity){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("devanshsharmads9935@gmail.com");
        int count = mailEntity.getRecipients().size() -1;
        while(count >= 0){
            message.setTo(mailEntity.getRecipients().get(count));
            message.setSubject(mailEntity.getSubject());
            message.setText(mailEntity.getBody());
            javaMailSender.send(message);
            count--;
        }

        return "Mail send";
    }


}
/*
        message.setTo(mailEntity.getTo());
        message.setText(mailEntity.getBody());
        message.setSubject(mailEntity.getSubject());

        javaMailSender.send(message);
 */