package com.academix.academix.services;

import com.academix.academix.data.AttendanceDataService;
import com.academix.academix.model.attendancemodel;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class attendanceServices {

    private static AttendanceDataService AttendancdeDAO;


    public static int markattendance(int scheduleId, String date, List<attendancemodel> aj) {
        return AttendancdeDAO.MarkAttendance(scheduleId,date,aj);
    }
}
