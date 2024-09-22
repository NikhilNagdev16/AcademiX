package com.academix.academix.services;

import com.academix.academix.data.AttendanceDataService;
import com.academix.academix.model.attendancemodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class attendanceServices {

    @Autowired
    AttendanceDataService AttendancdeDAO;


    public int markattendance(int scheduleId, String date, List<attendancemodel> aj) {
        return AttendancdeDAO.MarkAttendance(scheduleId,date,aj);
    }

    public List<attendancemodel> getAttendance(int scheduleId, String date) {
        return AttendancdeDAO.getAttendance(scheduleId, date);
    }

    public List<attendanceStudent> getAttendanceForUser(int userId){
        return AttendancdeDAO.getAttendanceForUser(userId);
    }
}
