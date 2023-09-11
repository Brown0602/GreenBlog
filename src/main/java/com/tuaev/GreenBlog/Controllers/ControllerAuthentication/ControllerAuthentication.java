package com.tuaev.GreenBlog.Controllers.ControllerAuthentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerAuthentication {

    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    public String authentication(){
        return "authentication";
    }

    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public String authentication(@RequestParam String email, @RequestParam String password){

        return "redirect:/";
    }
}
