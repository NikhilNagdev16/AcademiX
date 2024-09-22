package com.academix.academix.services;

import com.academix.academix.data.studentCourseDataService;
import com.academix.academix.model.studentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentCourseService {

    @Autowired
    studentCourseDataService service;

    public List<studentCourse> getStudentsByCourseId(int courseId){
        return service.getStudentsByCourseId(courseId);
    }

    public List<studentCourse> getStudentsBySubjectId(int subjectId){
        return service.getStudentsBySubjectId(subjectId);
    }
}
