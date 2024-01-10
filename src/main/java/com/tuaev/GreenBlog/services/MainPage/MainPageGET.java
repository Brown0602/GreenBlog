package com.tuaev.GreenBlog.services.MainPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class MainPageGET{

    public MainPageGET(){
    }

    public String mainPageGET(Model model, HttpSession session){
        String username = (String) session.getAttribute("username");
        if (username == null){
            model.addAttribute("username", null);
            return "mainPage";
        }else {
            model.addAttribute("username", username);
            model.addAttribute(username);
        }
        return "mainPage";
    }
}
