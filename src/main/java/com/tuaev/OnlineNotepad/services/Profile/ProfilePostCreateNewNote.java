package com.tuaev.OnlineNotepad.services.Profile;

import com.tuaev.OnlineNotepad.Repositories.CreateNewNote.CreateNewNote;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilePostCreateNewNote {

    CreateNewNote createNewNote;

    @Autowired
    ProfilePostCreateNewNote(CreateNewNote createNewNote){
        this.createNewNote = createNewNote;
    }

    public String profilePostCreateNewNote(String note_title, String note_description, HttpSession session){
        createNewNote.createNewNote(note_title, note_description, session);
        return "redirect:/profile";
    }
}
