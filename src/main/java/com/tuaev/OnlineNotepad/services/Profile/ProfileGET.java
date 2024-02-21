package com.tuaev.OnlineNotepad.services.Profile;

import com.tuaev.OnlineNotepad.Repositories.FindAllNotes.FindAllNotes;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProfileGET {

    FindAllNotes findAllNotes;

    @Autowired
    public ProfileGET(FindAllNotes findAllNotes){
        this.findAllNotes = findAllNotes;
    }

    public String profileGET(Model model, HttpSession session){
        String username = (String) session.getAttribute("username");
        if (username == null){
            model.addAttribute("username", null);
            return "redirect:/authentication";
        }else {
            List notes = findAllNotes.findAllNotes(session, model);
            model.addAttribute("notes", notes);
            model.addAttribute("username", username);
            model.addAttribute(username);
        }
        return "Profile";
    }
}
