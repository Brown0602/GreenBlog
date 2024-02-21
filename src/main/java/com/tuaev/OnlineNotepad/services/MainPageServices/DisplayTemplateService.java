package com.tuaev.OnlineNotepad.services.MainPageServices;

import com.tuaev.OnlineNotepad.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface DisplayTemplateService {
    String displayTemplate(Model model, HttpSession session, User user);
}
