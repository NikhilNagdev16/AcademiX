package com.academix.academix.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class studentCourseMapper implements RowMapper<studentCourse> {
    @Override
    public studentCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new studentCourse(rs.getInt(1), rs.getString(2), rs.getInt(3) );
    }
}
