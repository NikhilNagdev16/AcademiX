package com.academix.academix.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class subjectMapper implements RowMapper<subject> {
    @Override
    public subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new subject(rs.getInt("subject_id"),rs.getInt("course_id"), rs.getInt("semester"),
                rs.getString("subject_name"), rs.getInt("teacher_id"),
                rs.getInt("internal_marks"),rs.getInt("external_marks"), rs.getInt("practical_marks"));
    }
}
