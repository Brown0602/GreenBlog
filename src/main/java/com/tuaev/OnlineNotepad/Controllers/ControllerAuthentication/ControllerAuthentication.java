package com.tuaev.OnlineNotepad.Controllers.ControllerAuthentication;

import com.tuaev.OnlineNotepad.Repositories.FindByIdUser.FindById;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerAuthentication {

    @Autowired
    FindById findById;

    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    public String authentication(Model model){

        String userSearchErrorBoolean = "false";
        String userSearchError = "";
        model.addAttribute("userSearchErrorBoolean", userSearchErrorBoolean);
        model.addAttribute("userSearchError", userSearchError);

        return "authentication";
    }

    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public String authentication(Model model, @RequestParam String username, @RequestParam String email, @RequestParam String password, HttpSession session){
        return findById.findByEmailAndPassword(model, username, email, password, session);
    }
}
