package com.tuaev.GreenBlog.Controllers.ControllerForgotPassword;

import com.tuaev.GreenBlog.Repositories.RecoverPasswordUser.RecoverPasswordUser;
import com.tuaev.GreenBlog.dto.UserDTO;
import com.tuaev.GreenBlog.service.ComparisonCodeService.ComparisonCodeService;
import com.tuaev.GreenBlog.service.ForgotPassword.ForgotPasswordGET;
import com.tuaev.GreenBlog.service.ForgotPassword.ForgotPasswordPOST;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ControllerForgotPassword {

    ComparisonCodeService comparisonCodeService;
    UserDTO futureUser;
    RecoverPasswordUser recoverPasswordUser;
    ForgotPasswordGET forgotPasswordGET;
    ForgotPasswordPOST forgotPasswordPOST;

    public ControllerForgotPassword(ComparisonCodeService comparisonCodeService, UserDTO futureUser, RecoverPasswordUser recoverPasswordUser, ForgotPasswordGET forgotPasswordGET, ForgotPasswordPOST forgotPasswordPOST) {
        this.comparisonCodeService = comparisonCodeService;
        this.futureUser = futureUser;
        this.recoverPasswordUser = recoverPasswordUser;
        this.forgotPasswordGET = forgotPasswordGET;
        this.forgotPasswordPOST = forgotPasswordPOST;
    }

    @RequestMapping(value = "/forgot/password", method = RequestMethod.GET)
    public String recoverPassword(Model model) {
        return forgotPasswordGET.recoverPassword(model);
    }

    @RequestMapping(value = "/forgot/password", method = RequestMethod.POST)
    public String recoverPassword(Model model, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String code, @RequestParam(defaultValue = "") String newPassword) throws MessagingException, IOException {

        if (!email.equals("") && code.equals("") && newPassword.equals("")){
            futureUser.setEmail(email);
            return forgotPasswordPOST.recoverPassword(model, email);
        }

        if (email.equals("") && !code.equals("") && newPassword.equals("")){
            if (!code.equals(comparisonCodeService.getCode())) {
                String errorCode = "false";
                String errorComparisonCode = "Неправильный код подтверждения";
                model.addAttribute("errorCode", errorCode);
                model.addAttribute("errorComparisonCode", errorComparisonCode);
                return "ForgotPassword";
            }
            String formNewPassword = "true";
            model.addAttribute("newPassword", formNewPassword);
            return recoverPasswordUser.recoverPasswordUser(model, newPassword, futureUser.getEmail(), code);
        }

        if (email.equals("") && code.equals("") && !newPassword.equals("")){
            String formNewPassword = "true";
            model.addAttribute("newPassword", formNewPassword);
            return recoverPasswordUser.recoverPasswordUser(model, newPassword, futureUser.getEmail(), code);
        }

        return "";
    }
}

