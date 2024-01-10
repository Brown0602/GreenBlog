package com.tuaev.GreenBlog.services.RegistrationNewUserService;

import com.tuaev.GreenBlog.services.EmailAuthenticationService.EmailAuthenticationService;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.io.IOException;

@Service
public class RegistrationNewUserService {


    EmailAuthenticationService emailAuthentication;

    RegistrationNewUserService(EmailAuthenticationService emailAuthentication){
        this.emailAuthentication = emailAuthentication;
    }

    public String registrationNewUserGET(Model model){
        String registrationForm = "true";
        String registrationConfirmationForm = "false";
        model.addAttribute("registrationForm", registrationForm);
        model.addAttribute("registrationConfirmationForm", registrationConfirmationForm);
        return "registration";
    }

    public String registrationNewUserPOST(Model model, String email, String password, String checkPassword) throws MessagingException, IOException, MessagingException {

        if (!password.equals(checkPassword)){
            String registrationForm = "true";
            String registrationConfirmationForm = "false";
            String errorChecksPasswords = "true";
            String errorChecksPasswordsText = "Пароли не совпадают!";
            model.addAttribute("registrationForm", registrationForm);
            model.addAttribute("registrationConfirmationForm", registrationConfirmationForm);
            model.addAttribute("errorChecksPasswords", errorChecksPasswords);
            model.addAttribute("errorChecksPasswordsText", errorChecksPasswordsText);
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            model.addAttribute("checkPassword", checkPassword);
            return "registration";
        }else {
            return emailAuthentication.emailAuthentication(model, email);
        }
    }
}
