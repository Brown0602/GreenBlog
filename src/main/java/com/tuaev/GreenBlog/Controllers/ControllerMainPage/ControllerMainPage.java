package com.tuaev.GreenBlog.Controllers.ControllerMainPage;

import com.tuaev.GreenBlog.services.MainPage.MainPageGET;
import com.tuaev.GreenBlog.services.MainPage.MainPagePOST;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerMainPage {

    MainPageGET mainPageGET;
    MainPagePOST mainPagePOST;

    @Autowired
    public ControllerMainPage(MainPageGET mainPageGET, MainPagePOST mainPagePOST){
        this.mainPageGET = mainPageGET;
        this.mainPagePOST = mainPagePOST;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model, HttpSession session){
        return mainPageGET.mainPageGET(model, session);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String main(Model model, HttpSession session, @RequestParam String exit){
        return mainPagePOST.mainPagePOST(exit, session);
    }
}
