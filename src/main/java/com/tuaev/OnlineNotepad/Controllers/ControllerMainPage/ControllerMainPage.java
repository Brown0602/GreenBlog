package com.tuaev.OnlineNotepad.Controllers.ControllerMainPage;

import com.tuaev.OnlineNotepad.models.User;
import com.tuaev.OnlineNotepad.services.MainPageServices.DisplayTemplateService;
import com.tuaev.OnlineNotepad.services.MainPageServices.ExitProfileService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerMainPage {

    ExitProfileService exitProfileService;
    DisplayTemplateService displayTemplateService;

    @Autowired
    public ControllerMainPage(DisplayTemplateService displayTemplateService, ExitProfileService exitProfileService){
        this.displayTemplateService = displayTemplateService;
        this.exitProfileService = exitProfileService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model, HttpSession session, User user){
        return displayTemplateService.displayTemplate(model, session, user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String main(Model model, HttpSession session, @RequestParam String exit){
        return exitProfileService.exitProfile(model, session, exit);
    }
}
