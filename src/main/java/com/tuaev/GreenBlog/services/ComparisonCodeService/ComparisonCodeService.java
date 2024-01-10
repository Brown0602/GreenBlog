package com.tuaev.GreenBlog.services.ComparisonCodeService;

import com.tuaev.GreenBlog.Repositories.CreateNewUser.CreateNewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ComparisonCodeService {

    CreateNewUser createNewUser;

    private String Code;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    @Autowired
    public ComparisonCodeService(CreateNewUser createNewUser) {
        this.createNewUser = createNewUser;
    }

    public ComparisonCodeService(){

    }

    public String comparisonCode(Model model, String code, String username, String email, String password){

        if (code.equals(getCode())){
            createNewUser.NewUser(model, username, email, password);
            return "redirect:/";
        }else {
            String registrationForm = "false";
            String registrationConfirmationForm = "true";
            String errorChecksCode = "true";
            String errorChecksCodeText = "Неправильный код подтверждения!";
            model.addAttribute("errorChecksCode", errorChecksCode);
            model.addAttribute("errorChecksCodeText", errorChecksCodeText);
            model.addAttribute("registrationForm", registrationForm);
            model.addAttribute("registrationConfirmationForm", registrationConfirmationForm);
            return "registration";
        }
    }

}
