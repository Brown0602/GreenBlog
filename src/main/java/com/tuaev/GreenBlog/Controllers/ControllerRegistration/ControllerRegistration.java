package com.tuaev.GreenBlog.Controllers.ControllerRegistration;

import com.tuaev.GreenBlog.Repositories.CheckEmail.CheckEmail;
import com.tuaev.GreenBlog.dto.UserDTO;
import com.tuaev.GreenBlog.services.ComparisonCodeService.ComparisonCodeService;
import com.tuaev.GreenBlog.services.RegistrationNewUserService.RegistrationNewUserService;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

@Controller
public class ControllerRegistration {

    UserDTO userDTO;
    RegistrationNewUserService registrationNewUserService;
    CheckEmail checkEmail;
    ComparisonCodeService comparisonCode;

    public ControllerRegistration(RegistrationNewUserService registrationNewUserGET, CheckEmail checkEmail, UserDTO futureUser, ComparisonCodeService comparisonCode, RegistrationNewUserService registrationNewUserRepo){
        this.userDTO = futureUser;
        this.registrationNewUserService = registrationNewUserGET;
        this.checkEmail = checkEmail;
        this.comparisonCode = comparisonCode;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationNewUser(Model model){
        return registrationNewUserService.registrationNewUserGET(model);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationNewUser(Model model,
                                      @RequestParam(defaultValue = "") String username,
                                      @RequestParam(defaultValue = "") String code,
                                      @RequestParam(defaultValue = "") String email,
                                      @RequestParam(defaultValue = "") String password,
                                      @RequestParam(defaultValue = "") String checkPassword) throws IOException, MessagingException {

        if (!email.equals("") && !password.equals("") && !checkPassword.equals("")) {
            return checkEmail.checkEmail(model, username, email, password, checkPassword);
        }else {
            return comparisonCode.comparisonCode(model, code, userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
        }
    }

}
