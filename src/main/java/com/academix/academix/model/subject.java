package com.academix.academix.model;

public class subject {
    int subject_id;
    int course_id;
    int semester;
    String subject_name;
    int internal_marks;
    int external_marks;
    int practical_marks;

    public subject(int subject_id, int course_id, int semester, String subject_name, int internal_marks, int external_marks, int practical_marks) {
        this.subject_id = subject_id;
        this.course_id = course_id;
        this.semester = semester;
        this.subject_name = subject_name;
        this.internal_marks = internal_marks;
        this.external_marks = external_marks;
        this.practical_marks = practical_marks;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getInternal_marks() {
        return internal_marks;
    }

    public void setInternal_marks(int internal_marks) {
        this.internal_marks = internal_marks;
    }

    public int getExternal_marks() {
        return external_marks;
    }

    public void setExternal_marks(int external_marks) {
        this.external_marks = external_marks;
    }

    public int getPractical_marks() {
        return practical_marks;
    }

    public void setPractical_marks(int practical_marks) {
        this.practical_marks = practical_marks;
    }
}
