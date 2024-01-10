package com.tuaev.GreenBlog.Repositories.CreateNewUser;

import com.tuaev.GreenBlog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class CreateNewUser {

    User user;
    JdbcTemplate jdbcTemplate;

    @Autowired
    CreateNewUser(User user, JdbcTemplate jdbcTemplate){
        this.user = user;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void NewUser(Model model, String username, String email, String password){
        user.setUser_name(username);
        user.setUser_email(email);
        user.setUser_password(password);
        String sqlSave = "INSERT INTO users(user_name, user_email, user_password) VALUES(?, ?, ?)";
        jdbcTemplate.update(sqlSave, user.getUser_name(), user.getUser_email(), user.getUser_password());
    }

}
