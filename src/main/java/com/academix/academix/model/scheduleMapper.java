package com.academix.academix.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class scheduleMapper implements RowMapper<schedule> {
    @Override
    public schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new schedule(rs.getInt("schedule_id"),rs.getInt("course_id")
        ,rs.getInt("subject_id")
        ,rs.getString("day"), rs.getString("start_time")
        , rs.getString(6),rs.getInt(7) );
    }
}
