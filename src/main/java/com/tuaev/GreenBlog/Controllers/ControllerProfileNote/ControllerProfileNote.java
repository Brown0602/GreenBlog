package com.tuaev.GreenBlog.Controllers.ControllerProfileNote;

import com.tuaev.GreenBlog.Repositories.CreateNewNote.CreateNewNote;
import com.tuaev.GreenBlog.Repositories.DeleteNoteById.DeleteNoteById;
import com.tuaev.GreenBlog.services.Profile.ProfileGET;
import com.tuaev.GreenBlog.services.Profile.ProfileGetNoteId;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerProfileNote {

    DeleteNoteById deleteNoteById;
    ProfileGetNoteId profileGetNoteId;
    CreateNewNote createNewNote;

    @Autowired
    public ControllerProfileNote(DeleteNoteById deleteNoteById, ProfileGetNoteId profileGetNoteId, CreateNewNote createNewNote){
        this.deleteNoteById = deleteNoteById;
        this.profileGetNoteId = profileGetNoteId;
        this.createNewNote = createNewNote;
    }

    @RequestMapping(value = "/profile/note/{note_id}", method = RequestMethod.GET)
    public String personalProfileNoteRead(Model model, HttpSession session, @PathVariable("note_id") Long note_id){
        return profileGetNoteId.profileGetNoteId(session, model, note_id);
    }

    @RequestMapping(value = "/profile/note/{note_id}", method = RequestMethod.POST)
    public String personalProfileNoteDelete(@PathVariable("note_id") Long note_id, Model model, HttpSession session, @RequestParam(defaultValue = "Без названия") String note_title,
                                  @RequestParam(defaultValue = "") String note_description,
                                  @RequestParam(defaultValue = "") String search_notes){
//        createNewNote.createNewNote(note_title, note_description);
        deleteNoteById.deleteNote(note_id);
        return "redirect:/profile";
    }

}
