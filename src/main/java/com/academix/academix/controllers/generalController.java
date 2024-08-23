package com.academix.academix.controllers;

import com.academix.academix.model.collegeInfo;
import com.academix.academix.services.GeneralServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class generalController {
    @Autowired
    GeneralServices generalServices;

    @GetMapping("/getCollegeInfo")
    public collegeInfo getCollegeInfo(@RequestParam int collegeId){
        return generalServices.getCollegeInfo(collegeId);
    }

    @GetMapping("/getNoOfUsers")
    public int getNoUsers() {
        return generalServices.noOfUsers();
    }

    @GetMapping("/getNoOfColleges")
    public int getNoOfColleges() {
        return generalServices.noOfColleges();
    }

    @GetMapping("/getNoOfCourses")
    public int getNoOfCourses(@RequestParam int courseId) {
        return generalServices.noOfCourses(courseId);
    }

    @GetMapping("/getNoOfStudents")
    public int getNoOfStudents(@RequestParam int collegeID) {
        return generalServices.noOfStudents(collegeID);
    }

    @GetMapping("/getNoOfTeachers")
    public int getNoOfTeachers(@RequestParam int teacherId) {
        return generalServices.noOfTeachers(teacherId);
    }
}
