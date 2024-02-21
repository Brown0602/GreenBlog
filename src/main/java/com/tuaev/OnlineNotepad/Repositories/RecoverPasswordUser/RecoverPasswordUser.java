package com.tuaev.OnlineNotepad.Repositories.RecoverPasswordUser;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class RecoverPasswordUser {

    JdbcTemplate jdbcTemplate;

    public RecoverPasswordUser(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String recoverPasswordUser(Model model, String newPassword, String email, String code) {

        if (!code.equals("")) {
            return "ForgotPassword";
        } else {

            String sql = "UPDATE users SET user_password = ? WHERE user_email = ?";
            jdbcTemplate.update(sql, newPassword, email);

            return "redirect:/";
        }

    }
}
