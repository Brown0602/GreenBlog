package com.tuaev.GreenBlog.Controllers.ControllerRegistration;

import com.tuaev.GreenBlog.RegistrationNewUser.RegistrationNewUserRepo;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

@Controller
public class ControllerRegistration {

    RegistrationNewUserRepo registrationNewUserRepo;

    public ControllerRegistration(RegistrationNewUserRepo registrationNewUserRepo){
        this.registrationNewUserRepo = registrationNewUserRepo;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationNewUser(Model model){

        return registrationNewUserRepo.registrationNewUserGET(model);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationNewUser(Model model, @RequestParam String email, @RequestParam String password,
                                      @RequestParam String checkPassword) throws IOException, MessagingException {

        return registrationNewUserRepo.registrationNewUserPOST(model, email, password, checkPassword);
    }
}
