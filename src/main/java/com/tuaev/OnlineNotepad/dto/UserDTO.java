package com.tuaev.OnlineNotepad.dto;

public class UserDTO {

    private int fk_users_id;
    private String username;

    public int getFk_users_id() {
        return fk_users_id;
    }

    public void setFk_users_id(int fk_users_id) {
        this.fk_users_id = fk_users_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String email;
    private String password;

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

    public UserDTO() {
    }

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
