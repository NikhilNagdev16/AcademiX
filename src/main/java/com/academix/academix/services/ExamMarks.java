package com.academix.academix.services;

public class ExamMarks {
    private String subjectName;
    private int internal;
    private int external;
    private int practical;

    // Getters and setters

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getInternal() {
        return internal;
    }

    public void setInternal(int internal) {
        this.internal = internal;
    }

    public double getExternal() {
        return external;
    }

    public void setExternal(int external) {
        this.external = external;
    }

    public double getPractical() {
        return practical;
    }

    public void setPractical(int practical) {
        this.practical = practical;
    }
}
