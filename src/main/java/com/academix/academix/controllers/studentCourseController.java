package com.academix.academix.controllers;

import com.academix.academix.model.studentCourse;
import com.academix.academix.services.studentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class studentCourseController {

    @Autowired
    studentCourseService service;

    @GetMapping("/studentByCourse")
    public List<studentCourse> getStudentByCourse(@RequestParam int courseId) {
        return  service.getStudentsByCourseId(courseId);
    }

    @GetMapping("/studentBySubject")
    public List<studentCourse> getStudentsBySubjectId(int subjectId){
        return  service.getStudentsBySubjectId(subjectId);
    }
}
