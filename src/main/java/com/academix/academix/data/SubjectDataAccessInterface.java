package com.academix.academix.data;

import com.academix.academix.model.subject;

import java.util.List;


public interface SubjectDataAccessInterface {
    public int createSubject(subject sub);
    public List<subject> getAllSubjects(int courseId);
}
