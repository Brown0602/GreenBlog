package com.tuaev.GreenBlog.Controllers.ControllerRegistration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerRegistration {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationNewUser(){
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationNewUser(@RequestParam String email, @RequestParam String password,
                                      @RequestParam String checkPassword){
        return "redirect:/";
    }
}
