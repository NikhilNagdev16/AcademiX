package com.academix.academix.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class usersMapper implements RowMapper<users> {
    @Override
    public users mapRow(ResultSet rs, int rowNum) throws SQLException {


        users user = new users(rs.getInt("user_id"),
                                rs.getString("email"),
                                rs.getString("name"),
                                rs.getString("password"),
                                rs.getString("role"));

        return  user;
    }
}
