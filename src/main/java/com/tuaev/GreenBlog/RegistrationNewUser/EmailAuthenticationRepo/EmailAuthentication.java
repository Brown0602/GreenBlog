package com.tuaev.GreenBlog.RegistrationNewUser.EmailAuthenticationRepo;

import com.tuaev.GreenBlog.RegistrationNewUser.CodeAutoGeneration.CodeAutoGeneration;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.util.Properties;

@PropertySource("classpath:application.properties")
@Repository
public class EmailAuthentication {

    CodeAutoGeneration codeAutoGeneration;

    EmailAuthentication(CodeAutoGeneration codeAutoGeneration){
        this.codeAutoGeneration = codeAutoGeneration;
    }

    @Value("${mail.password}")
    private String mailPassword;
    @Value("${mail.myEmail}")
    private String myEmail;

    public void emailAuthentication(String email) throws MessagingException, IOException {

        final Properties properties = new Properties();
        properties.load(EmailAuthentication.class.getClassLoader().getResourceAsStream("application.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(myEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Подтверждение регистрации на сайте");
        String code = codeAutoGeneration.codeAutoGeneration();
        message.setText("Для потверждения регистрации введите в поле формы указанный код: " + code);
        Transport transport = mailSession.getTransport();
        transport.connect(myEmail, mailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

        }

}
