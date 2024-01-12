package com.tuaev.GreenBlog.Repositories.UpdateNoteById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateNoteById {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public UpdateNoteById(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateNoteById(String note_title, String note_description, Long note_id){
        String querySql = "UPDATE notes SET note_title = ?, note_description = ? WHERE note_id = ?";
        jdbcTemplate.update(querySql, note_title, note_description, note_id);
    }
}
