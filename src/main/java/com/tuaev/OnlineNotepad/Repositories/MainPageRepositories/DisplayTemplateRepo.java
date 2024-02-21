package com.tuaev.OnlineNotepad.Repositories.MainPageRepositories;

import com.tuaev.OnlineNotepad.models.User;
import com.tuaev.OnlineNotepad.services.MainPageServices.DisplayTemplateService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class DisplayTemplateRepo implements DisplayTemplateService {
    @Override
    public String displayTemplate(Model model, HttpSession session, User user) {
        model.addAttribute("username", session.getAttribute("username"));
        return "mainPage";
    }
}
