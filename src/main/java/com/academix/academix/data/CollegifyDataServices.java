package com.academix.academix.data;

import com.academix.academix.model.course;
import com.academix.academix.model.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Random;

@Repository
public class CollegifyDataServices {

    JdbcTemplate jdbcTemplate;
    public CollegifyDataServices(@Qualifier("collegifyJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addUser(users user){
        //        //adding to clgify db
        String sql2 = "INSERT INTO User (UserName, fname, Email, Password,lname) VALUES (?, ?, ?,?, ?)";

        // Create a KeyHolder to capture the generated user_id
        KeyHolder keyHolder2 = new GeneratedKeyHolder();

        // Execute the insert and capture the generated user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, "_");
            return ps;
        }, keyHolder2);
        int id = keyHolder2.getKey().intValue();
        return id;
    }

    public int CreateComm(String cname,String cadmin){
        Random random = new Random();
        int result = jdbcTemplate.queryForObject("SELECT UserID FROM User where Email = ?", Integer.class, cadmin);
        String sql2 = "INSERT INTO Community (Name, CreatorUserID, InviteCode, logo) VALUES (?, ?, ?,?)";

        // Create a KeyHolder to capture the generated user_id
        KeyHolder keyHolder2 = new GeneratedKeyHolder();

        // Execute the insert and capture the generated user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cname);
            ps.setInt(2, result);
            ps.setInt(3, random.nextInt(90000) + 10000);
            ps.setString(4, "__");
            return ps;
        }, keyHolder2);
        int id = keyHolder2.getKey().intValue();
        return id;

    }
}
