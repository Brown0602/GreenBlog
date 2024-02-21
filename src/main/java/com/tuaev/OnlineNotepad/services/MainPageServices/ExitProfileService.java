package com.tuaev.OnlineNotepad.services.MainPageServices;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface ExitProfileService {
    String exitProfile(Model model, HttpSession session, String exit);
}
