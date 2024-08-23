package com.academix.academix.model;

public class user_college {
    int user_college_id;
    int user_id;
    int college_id;

    public user_college(int user_college_id, int user_id, int college_id) {
        this.user_college_id = user_college_id;
        this.user_id = user_id;
        this.college_id = college_id;
    }

    public int getUser_college_id() {
        return user_college_id;
    }

    public void setUser_college_id(int user_college_id) {
        this.user_college_id = user_college_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }
}
