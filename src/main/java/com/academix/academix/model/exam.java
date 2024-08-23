package com.academix.academix.model;

public class exam {
    int exam_id;
    int subject_id;
    int student_id;
    String exam_type;
    float score;

    public exam(int exam_id, int subject_id, int student_id, String exam_type, float score) {
        this.exam_id = exam_id;
        this.subject_id = subject_id;
        this.student_id = student_id;
        this.exam_type = exam_type;
        this.score = score;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
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

    public String getExam_type() {
        return exam_type;
    }

    public void setExam_type(String exam_type) {
        this.exam_type = exam_type;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
