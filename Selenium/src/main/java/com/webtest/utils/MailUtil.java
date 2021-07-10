package com.webtest.utils;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
    private String context;
    private String sender;
    private String auth_code;
    private String[] to;

    Properties prop = new Properties();

    public MailUtil(String messages) throws IOException {
        String tomail = ReadProperties.getPropertyValue("tomail");
        to = tomail.split(",");
        this.context = messages;
        this.sender = ReadProperties.getPropertyValue("sender");
        this.auth_code = ReadProperties.getPropertyValue("auth_code");

        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.host", "smtp.qq.com");
        prop.put("mail.smtp.auth", true);
    }

    Session session = Session.getInstance(prop, new Authenticator() {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            // TODO Auto-generated method stub
            return new PasswordAuthentication(sender, auth_code);
        }

    });

    public void send() {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to[0]));
            message.setSubject("test");
            message.setContent(context, "text/html;charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
