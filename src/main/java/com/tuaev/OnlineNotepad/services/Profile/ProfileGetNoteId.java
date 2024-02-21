package com.tuaev.OnlineNotepad.services.Profile;

import com.tuaev.OnlineNotepad.Repositories.FindAllNotes.FindAllNotes;
import com.tuaev.OnlineNotepad.Repositories.ReadNoteValues.ReadNoteValues;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProfileGetNoteId {

    FindAllNotes findAllNotes;
    ReadNoteValues readNoteValues;

    @Autowired
    public ProfileGetNoteId(FindAllNotes findAllNotes, ReadNoteValues readNoteValues){
        this.findAllNotes = findAllNotes;
        this.readNoteValues = readNoteValues;
    }

    public String profileGetNoteId(HttpSession session, Model model, Long note_id){
        String username = (String) session.getAttribute("username");
        if (username == null){
            model.addAttribute("username", null);
//            return "redirect:/";
        }else {
            Boolean displayUpdateNote = true;
            model.addAttribute("displayUpdateNote", displayUpdateNote);
            List notes = findAllNotes.findAllNotes(session, model);
            model.addAttribute("notes", notes);
            readNoteValues.readNoteValues(note_id, model);
            model.addAttribute("username", username);
            model.addAttribute(username);
        }
        return "Profile";
    }
}
