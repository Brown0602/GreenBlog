package com.tuaev.GreenBlog.Repositories.FindByIdUser;

import com.tuaev.GreenBlog.models.User;
import com.tuaev.GreenBlog.userRowMapper.UserRowMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class FindById {

    User user;
    JdbcTemplate jdbcTemplate;
    @Autowired
    public FindById(User user, JdbcTemplate jdbcTemplate){
        this.user = user;
        this.jdbcTemplate = jdbcTemplate;
    }

    public String findByEmailAndPassword(Model model, String username, String email, String password, HttpSession session){


        try {
            String sql = "SELECT * FROM users WHERE user_name = ? AND user_email = ? AND user_password = ?";
            user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), username, email, password);
            session.setAttribute("username", username);
            session.setAttribute("user_id", user.getUser_id());
            return "redirect:/";
        }catch(DataAccessException ignored){
            String userSearchErrorBoolean = "true";
            String userSearchError = "Пользователь с такими данными не найден";
            model.addAttribute("userSearchErrorBoolean", userSearchErrorBoolean);
            model.addAttribute("userSearchError", userSearchError);

        }
        return "authentication";
    }
}
