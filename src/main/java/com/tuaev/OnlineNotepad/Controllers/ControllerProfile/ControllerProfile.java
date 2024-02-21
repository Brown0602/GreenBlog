package com.tuaev.OnlineNotepad.Controllers.ControllerProfile;

import com.tuaev.OnlineNotepad.services.Profile.ProfileGET;
import com.tuaev.OnlineNotepad.services.Profile.ProfilePostCreateNewNote;
import com.tuaev.OnlineNotepad.services.Profile.ProfilePostDeleteAllNotes;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerProfile {

    ProfileGET profileGET;
    ProfilePostCreateNewNote profilePostCreateNewNote;
    ProfilePostDeleteAllNotes profilePostDeleteAllNotes;

    @Autowired
    public ControllerProfile(ProfileGET profileGET, ProfilePostCreateNewNote profilePostCreateNewNote,
                             ProfilePostDeleteAllNotes profilePostDeleteAllNotes){
        this.profileGET = profileGET;
        this.profilePostCreateNewNote = profilePostCreateNewNote;
        this.profilePostDeleteAllNotes = profilePostDeleteAllNotes;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model, HttpSession session){
        return profileGET.profileGET(model, session);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String personalProfile(@RequestParam(defaultValue = "Без названия") String note_title,
                                  @RequestParam(defaultValue = "") String note_description,
                                  @RequestParam(defaultValue = "") String search_notes,
                                  @RequestParam(defaultValue = "") String delete,
                                  HttpSession session){
        if (delete.equals("Удалить")){
            return profilePostDeleteAllNotes.profilePostDeleteAllNotes(session);
        } else {
            return profilePostCreateNewNote.profilePostCreateNewNote(note_title, note_description, session);
        }
    }
}
