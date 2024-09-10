package com.academix.academix.model;

public class student_course {
    int student_id;
    int course_id;
    int roll_no;
    int student_course_id;

    public student_course(int student_id, int course_id, int roll_no, int student_course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.roll_no = roll_no;
        this.student_course_id = student_course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public int getStudent_course_id() {
        return student_course_id;
    }

    public void setStudent_course_id(int student_course_id) {
        this.student_course_id = student_course_id;
    }
}
