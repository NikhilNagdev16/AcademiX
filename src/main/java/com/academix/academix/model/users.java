package com.academix.academix.model;

public class users {
    int user_id;
    String email;
    String name;
    String password;
    String role;

    public users(int user_id, String email, String name, String password, String role) {
        this.user_id = user_id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
