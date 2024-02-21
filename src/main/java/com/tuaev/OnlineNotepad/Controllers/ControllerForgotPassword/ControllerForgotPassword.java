package com.tuaev.OnlineNotepad.Controllers.ControllerForgotPassword;

import com.tuaev.OnlineNotepad.Repositories.RecoverPasswordUser.RecoverPasswordUser;
import com.tuaev.OnlineNotepad.dto.UserDTO;
import com.tuaev.OnlineNotepad.services.ComparisonCodeService.ComparisonCodeService;
import com.tuaev.OnlineNotepad.services.ForgotPassword.ForgotPasswordGET;
import com.tuaev.OnlineNotepad.services.ForgotPassword.ForgotPasswordPOST;
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
    UserDTO userDTO;
    RecoverPasswordUser recoverPasswordUser;
    ForgotPasswordGET forgotPasswordGET;
    ForgotPasswordPOST forgotPasswordPOST;
    public ControllerForgotPassword(ComparisonCodeService comparisonCodeService, UserDTO futureUser, RecoverPasswordUser recoverPasswordUser, ForgotPasswordGET forgotPasswordGET, ForgotPasswordPOST forgotPasswordPOST) {
        this.comparisonCodeService = comparisonCodeService;
        this.userDTO = futureUser;
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
            userDTO.setEmail(email);
            return forgotPasswordPOST.recoverPassword(model, email);
        }else if (email.equals("") && !code.equals("") && newPassword.equals("")){
            if (!code.equals(comparisonCodeService.getCode())) {
                String comparisonCode = "true";
                String errorComparisonCode = "false";
                String errorComparisonCodeText = "Неправильный код подтверждения";
                model.addAttribute("comparisonCode", comparisonCode);
                model.addAttribute("errorComparisonCode", errorComparisonCode);
                model.addAttribute("errorComparisonCodeText", errorComparisonCodeText);
                return "ForgotPassword";
            }else {
                String formNewPassword = "true";
                model.addAttribute("newPassword", formNewPassword);
                return recoverPasswordUser.recoverPasswordUser(model, newPassword, userDTO.getEmail(), code);
            }
            }else if (email.equals("") && code.equals("") && !newPassword.equals("")){
            String formNewPassword = "true";
            model.addAttribute("newPassword", formNewPassword);
            return recoverPasswordUser.recoverPasswordUser(model, newPassword, userDTO.getEmail(), code);
        }
        return "";
    }
}

