package com.academix.academix.model;

public class course {
    int course_id;
    int college_id;
    String course_name;
    int semesters;
    int active_semester;

    public course(int course_id, int college_id, String course_name, int semesters, int active_semester) {
        this.course_id = course_id;
        this.college_id = college_id;
        this.course_name = course_name;
        this.semesters = semesters;
        this.active_semester = active_semester;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getSemesters() {
        return semesters;
    }

    public void setSemesters(int semesters) {
        this.semesters = semesters;
    }

    public int getActive_semester() {
        return active_semester;
    }

    public void setActive_semester(int active_semester) {
        this.active_semester = active_semester;
    }
}
