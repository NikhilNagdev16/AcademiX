package com.academix.academix.data;

import com.academix.academix.model.attendancemodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import com.google.gson.Gson;
import com.academix.academix.data.CollegeDataService;
import com.academix.academix.data.GeneralDataService;
import com.academix.academix.model.colleges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AttendanceDataService {



    JdbcTemplate jdbcTemplate;
    @Autowired
    public AttendanceDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int MarkAttendance(int scheduleId, String date, List<attendancemodel> aj) {
        // Convert List<attendancemodel> to JSON
        Gson gson = new Gson();
        String attendanceJson = gson.toJson(aj);

        // SQL query to insert data
        String sql = "INSERT INTO attendance (schedule_id, date, attendance_json) VALUES (?, ?, ?)";

        // Execute the query using JdbcTemplate and return the number of rows affected
        return jdbcTemplate.update(sql, scheduleId, date, attendanceJson);
    }
}
