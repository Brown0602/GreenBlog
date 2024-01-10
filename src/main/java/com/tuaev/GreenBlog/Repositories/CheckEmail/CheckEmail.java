package com.tuaev.GreenBlog.Repositories.CheckEmail;

import com.tuaev.GreenBlog.dto.UserDTO;
import com.tuaev.GreenBlog.models.User;
import com.tuaev.GreenBlog.services.RegistrationNewUserService.RegistrationNewUserService;
import com.tuaev.GreenBlog.userRowMapper.UserRowMapper;
import jakarta.mail.MessagingException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.io.IOException;

@Repository
public class CheckEmail {

    UserDTO userDTO;
    RegistrationNewUserService registrationNewUserService;
    User user;
    JdbcTemplate jdbcTemplate;

    public CheckEmail(UserDTO userDTO, RegistrationNewUserService registrationNewUserService, User user, JdbcTemplate jdbcTemplate) {
        this.userDTO = userDTO;
        this.registrationNewUserService = registrationNewUserService;
        this.user = user;
        this.jdbcTemplate = jdbcTemplate;
    }

    public String checkEmail(Model model, String username, String email, String password, String checkPassword) throws MessagingException, IOException {

        try {
            String sqlCheck = "SELECT * FROM users WHERE user_email = ?";
            jdbcTemplate.queryForObject(sqlCheck, new UserRowMapper(), email);
                String registrationForm = "true";
                String errorEmail = "true";
                String errorEmailText = "Пользователь с таким email уже существует";
                model.addAttribute("registrationForm", registrationForm);
                model.addAttribute("errorEmail", errorEmail);
                model.addAttribute("errorEmailText", errorEmailText);
                model.addAttribute("email", email);
                model.addAttribute("password", password);
                model.addAttribute("checkPassword", checkPassword);
                return "registration";
            }catch(EmptyResultDataAccessException emptyResultDataAccessException){
                userDTO.setUsername(username);
                userDTO.setEmail(email);
                userDTO.setPassword(password);
                return registrationNewUserService.registrationNewUserPOST(model, email, password, checkPassword);
        }
    }
}
