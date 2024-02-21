package com.tuaev.OnlineNotepad.Repositories.MainPageRepositories;

import com.tuaev.OnlineNotepad.services.MainPageServices.ExitProfileService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class ExitProfileRepo implements ExitProfileService {
    @Override
    public String exitProfile(Model model, HttpSession session, String exit) {

        if (exit.equals("Выйти")){
            session.removeAttribute("username");
            return "mainPage";
        }

        return "mainPage";
    }
}
