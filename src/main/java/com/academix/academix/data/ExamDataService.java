package com.academix.academix.data;

import com.academix.academix.model.ExamMarksRowMapper;
import com.academix.academix.model.attendancemodel;
import com.academix.academix.model.examModel;
import com.academix.academix.services.ExamMarks;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExamDataService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int MarkExam(int subjectId, List<examModel> em) {

        Gson gson = new Gson();
        String examJson = gson.toJson(em);

        // SQL query to insert data
        String sql = "INSERT INTO exams (subject_id, exam_json) VALUES (?, ?)";

        // Execute the query using JdbcTemplate and return the number of rows affected
        return jdbcTemplate.update(sql, subjectId,examJson);
    }
    public List<ExamMarks> getExamMarksByUserId(int userId) {
        String sql = "SELECT sb.subject_name, " +
                "JSON_UNQUOTE(JSON_EXTRACT(e.exam_json, '$[0].internal')) AS internal, " +
                "JSON_UNQUOTE(JSON_EXTRACT(e.exam_json, '$[0].external')) AS external, " +
                "JSON_UNQUOTE(JSON_EXTRACT(e.exam_json, '$[0].practical')) AS practical " +
                "FROM exams e " +
                "JOIN subjects sb ON e.subject_id = sb.subject_id " +
                "WHERE JSON_UNQUOTE(JSON_EXTRACT(e.exam_json, '$[0].userid')) = ?";

        return jdbcTemplate.query(sql, new Object[]{userId}, new ExamMarksRowMapper());
    }
}
