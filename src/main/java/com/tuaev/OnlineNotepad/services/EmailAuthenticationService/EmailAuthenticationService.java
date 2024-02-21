package com.tuaev.OnlineNotepad.services.EmailAuthenticationService;

import com.tuaev.OnlineNotepad.services.CodeAutoGenerationService.CodeAutoGenerationService;
import com.tuaev.OnlineNotepad.services.ComparisonCodeService.ComparisonCodeService;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Properties;

@PropertySource("classpath:application.properties")
@Service
public class EmailAuthenticationService {

    ComparisonCodeService comparisonCodeService;
    CodeAutoGenerationService codeAutoGenerationService;

    EmailAuthenticationService(ComparisonCodeService comparisonCode, CodeAutoGenerationService codeAutoGeneration){
        this.comparisonCodeService = comparisonCode;
        this.codeAutoGenerationService = codeAutoGeneration;
    }

    @Value("${mail.password}")
    private String mailPassword;
    @Value("${mail.myEmail}")
    private String myEmail;

    public String emailAuthentication(Model model, String email) throws MessagingException, IOException {

        final Properties properties = new Properties();
        properties.load(EmailAuthenticationService.class.getClassLoader().getResourceAsStream("application.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(myEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Подтверждение регистрации на сайте 'Заметки.ru'");
        String code = codeAutoGenerationService.codeAutoGeneration();
        comparisonCodeService.setCode(code);
        message.setText("Здравствуйте!\nДля подтверждения регистрации введите в поле формы указанный код: " + code);
        Transport transport = mailSession.getTransport();
        transport.connect(myEmail, mailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        String registrationForm = "false";
        String registrationConfirmationForm = "true";
        model.addAttribute("registrationForm", registrationForm);
        model.addAttribute("registrationConfirmationForm", registrationConfirmationForm);
        return "registration";
    }

}
