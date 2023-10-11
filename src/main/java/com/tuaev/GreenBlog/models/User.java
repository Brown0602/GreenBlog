package com.tuaev.GreenBlog.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("users")
public class User {

    @Id
    @Column("id")
    private long user_id;
    @Column("user_email")
    private String user_email;
    @Column("user_password")
    private String user_password;

    public User(long user_id, String user_email, String user_password){
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public User(){

    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }
}
