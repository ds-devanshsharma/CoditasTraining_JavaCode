package com.devansh.MailApplication.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

public interface MailService {
    //void sendMail() throws MessagingException, IOException;
    public String sendEmail(MailEntity mailEntity);
}
