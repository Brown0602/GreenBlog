package com.tuaev.GreenBlog.services.ForgotPassword;

import com.tuaev.GreenBlog.services.CodeAutoGenerationService.CodeAutoGenerationService;
import com.tuaev.GreenBlog.services.ComparisonCodeService.ComparisonCodeService;
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


@PropertySource("application.properties")
@Service
public class ForgotPasswordPOST {

    ComparisonCodeService comparisonCodeService;
    CodeAutoGenerationService codeAutoGenerationService;

    public ForgotPasswordPOST(ComparisonCodeService comparisonCodeService, CodeAutoGenerationService codeAutoGenerationService){
        this.comparisonCodeService = comparisonCodeService;
        this.codeAutoGenerationService = codeAutoGenerationService;
    }

    @Value("${mail.password}")
    private String mailPassword;
    @Value("${mail.myEmail}")
    private String myEmail;

    public String recoverPassword(Model model, String email) throws IOException, MessagingException {

        final Properties properties = new Properties();
        properties.load(ForgotPasswordPOST.class.getClassLoader().getResourceAsStream("application.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(myEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Восстановление пароля");
        String code = codeAutoGenerationService.codeAutoGeneration();
        comparisonCodeService.setCode(code);
        message.setText("Для изменения пароля введите в поле формы указанный код: " + code);
        Transport transport = mailSession.getTransport();
        transport.connect(myEmail, mailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        String comparisonCode = "true";
        model.addAttribute("comparisonCode", comparisonCode);
        return "ForgotPassword";
    }
}
