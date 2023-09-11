package com.tuaev.GreenBlog.Controllers.ControllerForgotPassword;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecoverPassword {

    @RequestMapping(value = "/recover/password", method = RequestMethod.GET)
    public String recoverPassword(){
        return "recoverPassword";
    }
}
