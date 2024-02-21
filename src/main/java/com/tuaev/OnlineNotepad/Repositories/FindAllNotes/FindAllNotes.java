package com.tuaev.OnlineNotepad.Repositories.FindAllNotes;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public class FindAllNotes {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public FindAllNotes(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List findAllNotes(HttpSession session, Model model){
        Long fk_users_id = (Long) session.getAttribute("user_id");
        Long user_id = (Long) session.getAttribute("user_id");
        String query2 = "SELECT notes.note_id, notes.note_title, notes.note_description FROM notes JOIN users ON notes.fk_users_id = ? AND users.user_id = ?";
        List notes = jdbcTemplate.queryForList(query2, fk_users_id, user_id);


        return notes;
    }
}
