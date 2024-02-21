package com.tuaev.OnlineNotepad.services.UpdateNoteByIdService;

import com.tuaev.OnlineNotepad.Repositories.UpdateNoteById.UpdateNoteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateNoteByIdService {

    UpdateNoteById updateNoteById;

    @Autowired
    public UpdateNoteByIdService(com.tuaev.OnlineNotepad.Repositories.UpdateNoteById.UpdateNoteById updateNoteById) {
        this.updateNoteById = updateNoteById;
    }

    public String updateNoteById(){
        return "redirect:/profile";
    }
}
