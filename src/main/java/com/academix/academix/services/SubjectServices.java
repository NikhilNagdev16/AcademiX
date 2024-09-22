package com.academix.academix.services;

import com.academix.academix.data.SubjectDataService;
import com.academix.academix.model.subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServices implements SubjectServiceInterface {

    @Autowired
    SubjectDataService subjectDAO;

    @Override
    public int createSubject(subject sub) {
        return subjectDAO.createSubject(sub);
    }

    @Override
    public List<subject> getAllSubjects(int courseId) {
        return subjectDAO.getAllSubjects(courseId);
    }

    @Override
    public List<subject> getSubjectsByteacher(int teacherId) {
        return subjectDAO.getSubjectsByteacher(teacherId);
    }
}
