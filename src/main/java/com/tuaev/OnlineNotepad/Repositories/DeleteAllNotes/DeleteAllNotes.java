package com.tuaev.OnlineNotepad.Repositories.DeleteAllNotes;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteAllNotes {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public DeleteAllNotes(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteAllNotes(HttpSession session){
        Long fk_users_id = (Long) session.getAttribute("user_id");
        String query = "DELETE FROM notes WHERE fk_users_id = ?";
        jdbcTemplate.update(query, fk_users_id);
    }

}
