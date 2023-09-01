package com.tuaev.GreenBlog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerOne {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model){

        String helloWorld = "Hello World!";
        model.addAttribute("helloWorld", helloWorld);

        return "main";
    }

}
