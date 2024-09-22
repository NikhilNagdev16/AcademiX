package com.academix.academix.controllers;

import com.academix.academix.model.collegeInfo;
import com.academix.academix.services.GeneralServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    public int getNoOfCourses(@RequestParam int collegeId) {
        return generalServices.noOfCourses(collegeId);
    }

    @GetMapping("/getNoOfStudents")
    public int getNoOfStudents(@RequestParam int collegeID) {
        return generalServices.noOfStudents(collegeID);
    }

    @GetMapping("/getNoOfTeachers")
    public int getNoOfTeachers(@RequestParam int collegeId) {
        return generalServices.noOfTeachers(collegeId);
    }
    @GetMapping("/getNoOfLecturesTeacher")
    public int getNoOfLecturesTeacher(@RequestParam int teacherId) {
        return generalServices.noOfLecturesTeacher(teacherId);
    }
    @GetMapping("/getNoOfLecturesStudent")
    public int getNoOfLecturesStudent(@RequestParam int studentId) {
        return generalServices.noOfLecturesStudent(studentId);
    }
    @GetMapping("/getNoOfSubjectsTeacher")
    public int getNoOfSubjectsTeacher(@RequestParam int teacherId) {
        return generalServices.noOfSubjectsTeacher(teacherId);
    }
}
