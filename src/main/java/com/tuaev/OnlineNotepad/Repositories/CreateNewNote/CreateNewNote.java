package com.tuaev.OnlineNotepad.Repositories.CreateNewNote;

import com.tuaev.OnlineNotepad.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateNewNote {

    User user;
    JdbcTemplate jdbcTemplate;

    @Autowired
    public CreateNewNote(User user, JdbcTemplate jdbcTemplate){
        this.user = user;
        this.jdbcTemplate= jdbcTemplate;
    }

    public void createNewNote(String note_title, String note_description, HttpSession session){

        Long fk_users_id = (Long) session.getAttribute("user_id");
        String query = "INSERT INTO notes(note_title, note_description, fk_users_id) VALUES(?, ?, ?)";
        jdbcTemplate.update(query, note_title, note_description, fk_users_id);

    }
}
