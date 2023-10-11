package com.tuaev.GreenBlog.Repositories.CreateNewUser;

import com.tuaev.GreenBlog.models.User;
import com.tuaev.GreenBlog.userRowMapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class CreateNewUser {

    User user;
    JdbcTemplate jdbcTemplate;

    CreateNewUser(User user, JdbcTemplate jdbcTemplate){
        this.user = user;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void NewUser(Model model, String email, String password){
        user.setUser_email(email);
        user.setUser_password(password);
        String sqlSave = "INSERT INTO users(user_email, user_password) VALUES(?, ?)";
        jdbcTemplate.update(sqlSave, user.getUser_email(), user.getUser_password());
    }

}
