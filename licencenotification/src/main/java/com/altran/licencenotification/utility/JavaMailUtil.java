/*
  Created by  : Vivek Kumar
  Created on  : 19/06/2020
  Purpose     : Send Mail to registered Users.
 */
package com.altran.licencenotification.utility;

import com.altran.licencenotification.service.LicenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Service
public class JavaMailUtil {

    //Logger
    public static final Logger log = LoggerFactory.getLogger(JavaMailUtil.class);

    public static void sendMail(String recipient) throws MessagingException {
        log.info("--------------sendMail----------------");
        // Getting system properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");

        // Setting up mail server
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        // email ID of  Sender.
        String sender = "From which user want to sent the mail";
        String password = "Password of above mail";

        // creating session object to get properties
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender,password);
            }


        });
        Message message = prepareMessage(session,sender,recipient);
        // Send email.
        Transport.send(message);
        log.info("Mail successfully sent");

    }
    private static Message prepareMessage(Session session, String sender, String recipient) {
        // MimeMessage object.
        MimeMessage message = new MimeMessage(session);
        try
        {
            // Set From Field: adding senders email to from field.
            message.setFrom(new InternetAddress(sender));

            // Set To Field: adding recipient's email to from field.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: subject of the email
            message.setSubject("This is Suject");

            // set body of the email.
            message.setText("This is a test mail");
            return  message;

        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }
        return null;
    }
}
