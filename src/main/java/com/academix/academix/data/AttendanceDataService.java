package com.academix.academix.data;

import com.academix.academix.model.attendancemodel;
import com.academix.academix.services.attendanceStudent;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import com.google.gson.Gson;
import com.academix.academix.data.CollegeDataService;
import com.academix.academix.data.GeneralDataService;
import com.academix.academix.model.colleges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AttendanceDataService implements AttendanceDataInterface {


    @Autowired
    JdbcTemplate jdbcTemplate;


    public int MarkAttendance(int scheduleId, String date, List<attendancemodel> aj) {
        // Convert List<attendancemodel> to JSON
        Gson gson = new Gson();
        String attendanceJson = gson.toJson(aj);

        // SQL query to insert data
        String sql = "INSERT INTO attendance (schedule_id, date, attendance_json) VALUES (?, ?, ?)";

        // Execute the query using JdbcTemplate and return the number of rows affected
        return jdbcTemplate.update(sql, scheduleId, date, attendanceJson);
    }

    public List<attendancemodel> getAttendance(int scheduleId, String date) {
        String sql = "SELECT attendance_json FROM attendance WHERE schedule_id = ? AND date = ?";
        List<String> attendanceJsonList = jdbcTemplate.queryForList(sql, new Object[]{scheduleId, date}, String.class);

        List<attendancemodel> attendanceRecords = new ArrayList<>();
        Gson gson = new Gson();

        for (String attendanceJson : attendanceJsonList) {
            List<attendancemodel> records = gson.fromJson(attendanceJson, new TypeToken<List<attendancemodel>>(){}.getType());
            attendanceRecords.addAll(records);
        }

        return attendanceRecords;
    }
    public List<attendanceStudent> getAttendanceForUser(int userId) {
        String sql = """
  
                SELECT
      s.subject_name,
      a.date,
      JSON_UNQUOTE(JSON_EXTRACT(a.attendance_json, CONCAT('$[', idx.i, '].rollno'))) AS roll_no,
      JSON_UNQUOTE(JSON_EXTRACT(a.attendance_json, CONCAT('$[', idx.i, '].status'))) AS status
  FROM
      attendance a
  JOIN
      schedules sch ON sch.schedule_id = a.schedule_id
  JOIN
      subjects s ON s.subject_id = sch.subject_id
  JOIN
      (SELECT
           a.attendance_id,
           JSON_LENGTH(a.attendance_json) AS length
       FROM
           attendance a) AS lengths ON lengths.attendance_id = a.attendance_id
  JOIN
      (SELECT
           0 AS i UNION ALL
           SELECT 1 UNION ALL
           SELECT 2 UNION ALL
           SELECT 3 UNION ALL
           SELECT 4 UNION ALL
           SELECT 5 UNION ALL
           SELECT 6 UNION ALL
           SELECT 7 UNION ALL
           SELECT 8 UNION ALL
           SELECT 9 UNION ALL
           SELECT 10) AS idx
      ON idx.i < lengths.length
      AND JSON_UNQUOTE(JSON_EXTRACT(a.attendance_json, CONCAT('$[', idx.i, '].userid'))) = ?
  WHERE
      idx.i < lengths.length
  ORDER BY
      a.date;
    """;

        // Execute the query
        return jdbcTemplate.query(sql, new Object[]{userId}, this::mapRowToAttendanceRecord);
    }

    private attendanceStudent mapRowToAttendanceRecord(ResultSet rs, int rowNum) throws SQLException {
        attendanceStudent record = new attendanceStudent();
        record.setSubjectName(rs.getString("subject_name"));
        record.setDate(rs.getString("date"));
        record.setRollNo(rs.getInt("roll_no"));
        record.setStatus(rs.getBoolean("status"));
        return record;
    }
}

