package com.academix.academix.data;

import com.academix.academix.model.attendancemodel;

import java.util.List;

public interface AttendanceDataInterface {
    public int MarkAttendance(int scheduleId, String date, List<attendancemodel> aj);
}
