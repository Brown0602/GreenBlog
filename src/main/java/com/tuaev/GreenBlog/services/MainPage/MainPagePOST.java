package com.tuaev.GreenBlog.services.MainPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class MainPagePOST {

    public String mainPagePOST(String exit, HttpSession session){
        if (exit.equals("Выйти")){
            session.removeAttribute("username");
        }
        return "mainPage";
    }
}
