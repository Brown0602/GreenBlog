package com.tuaev.GreenBlog.services.ForgotPassword;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ForgotPasswordGET {

    public String recoverPassword(Model model){
        return "ForgotPassword";
    }

}
