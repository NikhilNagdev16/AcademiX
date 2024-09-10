package com.academix.academix.model;

public class schedule {
    int schedule_id;
    int course_id;
    int subject_id;

    String day;
    String start_time;
    String end_time;
    int class_no;

    public schedule(int schedule_id, int course_id, int subject_id, String day, String start_time, String end_time, int class_no) {
        this.schedule_id = schedule_id;
        this.course_id = course_id;
        this.subject_id = subject_id;
        this.day = day;
        this.start_time = start_time;
        this.end_time = end_time;
        this.class_no = class_no;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getClass_no() {
        return class_no;
    }

    public void setClass_no(int class_no) {
        this.class_no = class_no;
    }
}
