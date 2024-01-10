package com.tuaev.GreenBlog.NoteRowMapper;

import com.tuaev.GreenBlog.models.Note;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteRowMapper implements RowMapper<Note> {
    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {

        Note note = new Note();

        note.setNote_id(rs.getInt("note_id"));
        note.setNote_title(rs.getString("note_title"));
        note.setNote_description(rs.getString("note_description"));
        note.setFk_users_id(rs.getInt("fk_users_id"));

        return note;
    }
}
