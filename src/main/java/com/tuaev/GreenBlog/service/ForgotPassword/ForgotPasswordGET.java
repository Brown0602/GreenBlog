package com.tuaev.GreenBlog.service.ForgotPassword;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ForgotPasswordGET {

    public String recoverPassword(Model model){
        String errorCode = "";
        String comparisonCode = "";
        model.addAttribute("comparisonCode", comparisonCode);
        model.addAttribute("errorCode", errorCode);
        return "ForgotPassword";
    }

}
