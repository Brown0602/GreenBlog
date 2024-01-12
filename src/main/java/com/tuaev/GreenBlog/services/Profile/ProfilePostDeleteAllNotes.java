package com.tuaev.GreenBlog.services.Profile;

import com.tuaev.GreenBlog.Repositories.DeleteAllNotes.DeleteAllNotes;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilePostDeleteAllNotes {

    DeleteAllNotes deleteAllNotes;

    @Autowired
    public ProfilePostDeleteAllNotes(DeleteAllNotes deleteAllNotes){
        this.deleteAllNotes = deleteAllNotes;
    }

    public String profilePostDeleteAllNotes(HttpSession session){
        deleteAllNotes.deleteAllNotes(session);
        return "redirect:/profile";
    }

}
