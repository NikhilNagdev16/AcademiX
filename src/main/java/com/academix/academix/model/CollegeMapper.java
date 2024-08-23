package com.academix.academix.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CollegeMapper implements RowMapper<colleges>{
    @Override
    public colleges mapRow(ResultSet rs, int rowNum) throws SQLException {

        colleges college = new colleges(rs.getInt("college_id"),
                                        rs.getString("college_name"),
                                        rs.getString("address"),
                                        rs.getString("phone"),
                                        rs.getString("email"),
                                        rs.getInt("no_of_classes"),
                                        rs.getString("logo"));
        return college;
    }
}
