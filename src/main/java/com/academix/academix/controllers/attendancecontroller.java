package com.academix.academix.controllers;

import com.academix.academix.model.attendancemodel;
import com.academix.academix.model.subject;
import com.academix.academix.services.attendanceServices;
import com.academix.academix.services.attendanceStudent;
import com.academix.academix.services.usersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class attendancecontroller {

    @Autowired
    attendanceServices attendanceService;

    @PostMapping("/markAttendance")
    public int markattendance(@RequestParam int scheduleId, @RequestParam String date ,@RequestBody List<attendancemodel> aj){
        return attendanceService.markattendance(scheduleId,date,aj);
    }

    @GetMapping("/viewAttendance")
    public List<attendancemodel> viewAttendance(@RequestParam int scheduleId, @RequestParam String date) {
        return attendanceService.getAttendance(scheduleId, date);
    }

    @GetMapping("/studentAttendance")
    public List<attendanceStudent> getAttendanceForUser(@RequestParam int userId){
        return attendanceService.getAttendanceForUser(userId);
    }

}
