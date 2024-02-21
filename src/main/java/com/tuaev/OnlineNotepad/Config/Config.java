package com.tuaev.OnlineNotepad.Config;

import com.tuaev.OnlineNotepad.dto.UserDTO;
import com.tuaev.OnlineNotepad.models.Note;
import com.tuaev.OnlineNotepad.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserDTO futureUser() {
        return new UserDTO();
    }

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Note note(){
        return new Note();
    }
}

