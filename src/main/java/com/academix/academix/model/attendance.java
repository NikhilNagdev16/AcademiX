package com.academix.academix.model;

public class attendance {
    int attendance_id;
    int subject_id;
    int student_id;
    String date;
    boolean status;

    public attendance(int attendance_id, int subject_id, int student_id, String date, boolean status) {
        this.attendance_id = attendance_id;
        this.subject_id = subject_id;
        this.student_id = student_id;
        this.date = date;
        this.status = status;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
