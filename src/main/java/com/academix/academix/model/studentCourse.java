package com.academix.academix.model;

public class studentCourse {
    int user_id;
    String Name;
    int rollNo;

    public studentCourse(int user_id, String name, int rollNo) {
        this.user_id = user_id;
        Name = name;
        this.rollNo = rollNo;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
