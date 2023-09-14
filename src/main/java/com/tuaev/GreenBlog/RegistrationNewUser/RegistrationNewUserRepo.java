package com.tuaev.GreenBlog.RegistrationNewUser;

import com.tuaev.GreenBlog.RegistrationNewUser.EmailAuthenticationRepo.EmailAuthentication;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import java.io.IOException;

@Repository
public class RegistrationNewUserRepo {

    EmailAuthentication emailAuthentication;

    RegistrationNewUserRepo(EmailAuthentication emailAuthentication){
        this.emailAuthentication = emailAuthentication;
    }

    public String registrationNewUserGET(Model model){

        String errorChecksPasswords = "";
        String email = "";
        String password = "";
        String checkPassword = "";
        model.addAttribute("errorChecksPasswords", errorChecksPasswords);
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        model.addAttribute("checkPassword", checkPassword);

        return "registration";
    }

    public String registrationNewUserPOST(Model model, String email, String password, String checkPassword) throws MessagingException, IOException, MessagingException {

        if (!password.equals(checkPassword)){

            String errorChecksPasswords = "Пароли не совпадают!";
            String emailPOST = email;
            String passwordPOST = password;
            String checkPasswordPOST = checkPassword;
            model.addAttribute("errorChecksPasswords", errorChecksPasswords);
            model.addAttribute("email", emailPOST);
            model.addAttribute("password", passwordPOST);
            model.addAttribute("checkPassword", checkPasswordPOST);
            return "registration";
        }else {
            emailAuthentication.emailAuthentication(email);
            return "redirect:/";
        }
    }

}
