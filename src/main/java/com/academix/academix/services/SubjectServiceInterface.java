package com.academix.academix.services;

import com.academix.academix.model.subject;

import java.util.List;

public interface SubjectServiceInterface {
    public int createSubject(subject sub);
    public List<subject> getAllSubjects(int courseId);
}
