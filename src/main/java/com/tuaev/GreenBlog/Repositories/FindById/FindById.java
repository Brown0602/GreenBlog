package com.tuaev.GreenBlog.Repositories.FindById;

import com.tuaev.GreenBlog.userRowMapper.UserRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class FindById {

    JdbcTemplate jdbcTemplate;

    public FindById(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String findByEmailAndPassword(Model model, String email, String password){

        try {

            String sql = "SELECT * FROM users WHERE user_email = ? AND user_password = ?";
            jdbcTemplate.queryForObject(sql, new UserRowMapper(), email, password);

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
