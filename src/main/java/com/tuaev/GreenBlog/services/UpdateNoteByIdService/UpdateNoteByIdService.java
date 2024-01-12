package com.tuaev.GreenBlog.services.UpdateNoteByIdService;

import com.tuaev.GreenBlog.Repositories.UpdateNoteById.UpdateNoteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateNoteByIdService {

    UpdateNoteById updateNoteById;

    @Autowired
    public UpdateNoteByIdService(com.tuaev.GreenBlog.Repositories.UpdateNoteById.UpdateNoteById updateNoteById) {
        this.updateNoteById = updateNoteById;
    }

    public String updateNoteById(){
        return "redirect:/profile";
    }
}
