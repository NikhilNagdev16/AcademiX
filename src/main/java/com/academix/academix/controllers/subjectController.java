package com.academix.academix.controllers;

import com.academix.academix.model.subject;
import com.academix.academix.model.userCollege;
import com.academix.academix.services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class subjectController {

    @Autowired
    SubjectServices subjectServices;

    @PostMapping("/addSubject")
    public int addCollege(@RequestBody subject sub){
        return subjectServices.createSubject(sub);
    }

    @GetMapping("/subject")
    public List<subject> getSub(@RequestParam int courseId){
        return subjectServices.getAllSubjects(courseId);
    }
    @GetMapping("/subjectTeacher")
    public List<subject> getSubByTeacher(@RequestParam int TeacherId){
        return subjectServices.getSubjectsByteacher(TeacherId);
    }
}
