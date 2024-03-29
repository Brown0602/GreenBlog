package com.tuaev.OnlineNotepad.Repositories.DeleteNoteById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteNoteById {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public DeleteNoteById(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String deleteNote(Long note_id){
        String query = "DELETE FROM notes WHERE note_id = ?";
        jdbcTemplate.update(query, note_id);

        return "redirect:/profile";
    }
}
