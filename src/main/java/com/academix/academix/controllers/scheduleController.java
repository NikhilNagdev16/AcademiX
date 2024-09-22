package com.academix.academix.controllers;

import com.academix.academix.model.schedule;
import com.academix.academix.services.scheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class scheduleController {

   @Autowired
    scheduleService scheduleService;

    @PostMapping("/addSchedule")
    public int addSchedule(@RequestBody schedule s) {
        return  scheduleService.addSchedule(s);
    }

    @GetMapping("/scheduleStudent")
    public List<schedule> getScheduleStudent(int studentId) {
        return scheduleService.getByStudent(studentId);
    }

    @GetMapping("/scheduleTeacher")
    public List<schedule> getScheduleTeacher(int teacherId) {
        return scheduleService.getByTeacher(teacherId);
    }

    @GetMapping("/scheduleCourse")
    public List<schedule> getScheduleCourse(int courseId) {
        return scheduleService.getByCourse(courseId);
    }

    @GetMapping("/scheduleForAttendance")
    public List<schedule> getScheduleForAttendance(@RequestParam int subjectId,@RequestParam String day) {
        return scheduleService.getScheduleForAttendance(subjectId,day);
    }

}
