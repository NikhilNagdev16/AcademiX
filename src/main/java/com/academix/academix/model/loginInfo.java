package com.academix.academix.model;

public class loginInfo {
    int userID;
    String name;
    String role;
    int collegeId;
    public loginInfo(int userID, String name, String role, int collegeId) {
        this.userID = userID;
        this.name = name;
        this.role = role;
        this.collegeId = collegeId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }
}
