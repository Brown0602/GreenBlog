package com.tuaev.OnlineNotepad.Repositories.ReadNoteValues;

import com.tuaev.OnlineNotepad.NoteRowMapper.NoteRowMapper;
import com.tuaev.OnlineNotepad.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class ReadNoteValues {

    Note note;
    JdbcTemplate jdbcTemplate;

    @Autowired
    public ReadNoteValues(JdbcTemplate jdbcTemplate, Note note){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void readNoteValues(Long note_id, Model model){
        String query = "SELECT * FROM notes WHERE note_id = ?";
        note = jdbcTemplate.queryForObject(query, new NoteRowMapper(), note_id);
        model.addAttribute("note_title", note.getNote_title());
        model.addAttribute("note_description", note.getNote_description());
    }

}
