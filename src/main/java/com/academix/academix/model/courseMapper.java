package com.academix.academix.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class courseMapper implements RowMapper<course> {
    @Override
    public course mapRow(ResultSet rs, int rowNum) throws SQLException {


        course cr  = new course(rs.getInt("course_id"),
                rs.getInt("college_id"),
                rs.getString("course_name"),
                rs.getInt("semesters"),
                rs.getInt("active_semester"));

        return  cr;
    }
}
