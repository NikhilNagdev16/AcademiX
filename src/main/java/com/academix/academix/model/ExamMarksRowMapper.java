package com.academix.academix.model;

import com.academix.academix.services.ExamMarks;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamMarksRowMapper implements RowMapper<ExamMarks> {
    @Override
    public ExamMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
        ExamMarks marks = new ExamMarks();
        marks.setSubjectName(rs.getString("subject_name"));
        marks.setInternal(rs.getInt("internal"));
        marks.setExternal(rs.getInt("external"));
        marks.setPractical(rs.getInt("practical"));
        return marks;
    }
}
