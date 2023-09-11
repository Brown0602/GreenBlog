package com.tuaev.GreenBlog.models;

public class RegistrationNewUser {

    private long user_id;
    private String email;
    private String password;
    private String checkPassword;

    public RegistrationNewUser() {
    }

    public RegistrationNewUser(String email, String password, String checkPassword) {
        this.email = email;
        this.password = password;
        this.checkPassword = checkPassword;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }
}
