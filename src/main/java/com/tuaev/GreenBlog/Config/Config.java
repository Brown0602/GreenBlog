package com.tuaev.GreenBlog.Config;

import com.tuaev.GreenBlog.dto.UserDTO;
import com.tuaev.GreenBlog.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserDTO futureUser(){
        return new UserDTO();
    }

    @Bean
    public User user(){
        return new User();
    }

}
