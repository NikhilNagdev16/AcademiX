package com.academix.academix.model;

public class collegeInfo {
    int noOfUsers;
    String name;
    String logo;
    int noOfStudents;
    int noOfCourses;
    int noOfTeachers;

    public collegeInfo(int noOfUsers, String name, String logo, int noOfStudents, int noOfCourses, int noOfTeachers) {
        this.noOfUsers = noOfUsers;
        this.name = name;
        this.logo = logo;
        this.noOfStudents = noOfStudents;
        this.noOfCourses = noOfCourses;
        this.noOfTeachers = noOfTeachers;
    }

    public int getNoOfUsers() {
        return noOfUsers;
    }

    public void setNoOfUsers(int noOfUsers) {
        this.noOfUsers = noOfUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public int getNoOfCourses() {
        return noOfCourses;
    }

    public void setNoOfCourses(int noOfCourses) {
        this.noOfCourses = noOfCourses;
    }

    public int getNoOfTeachers() {
        return noOfTeachers;
    }

    public void setNoOfTeachers(int noOfTeachers) {
        this.noOfTeachers = noOfTeachers;
    }
}
