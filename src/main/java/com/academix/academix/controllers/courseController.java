package com.academix.academix.controllers;

import com.academix.academix.model.course;
import com.academix.academix.model.users;
import com.academix.academix.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class courseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courseByID")
    public course getCourseByID(@RequestParam int courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/course")
    public List<course> getCourseByCollegeID(@RequestParam int collegeId){
        return courseService.getCourseByCollegeId(collegeId);
    }

    @PostMapping("/addCourse")
    public int addCourse(@RequestBody course c){
        System.out.println(c);
        return courseService.addCourse(c);
    }
}
