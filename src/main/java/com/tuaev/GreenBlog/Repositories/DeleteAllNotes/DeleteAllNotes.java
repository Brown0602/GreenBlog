package com.tuaev.GreenBlog.Repositories.DeleteAllNotes;

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

    public void deleteAllNotes(){
        String query = "DELETE FROM notes";
        jdbcTemplate.update(query);
    }

}
