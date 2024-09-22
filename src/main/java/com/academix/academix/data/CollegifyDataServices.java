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

    public int addUser(users user,int userID){
        //        //adding to clgify db
        String sql2 = "INSERT INTO User (UserId,UserName, fname, Email, Password,lname) VALUES (?,?, ?, ?,?, ?)";

        // Create a KeyHolder to capture the generated user_id
        KeyHolder keyHolder2 = new GeneratedKeyHolder();

        // Execute the insert and capture the generated user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userID);
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setString(6, "_");
            return ps;
        }, keyHolder2);
        int id = keyHolder2.getKey().intValue();
        return id;
    }

    public int CreateComm(int CourseId,String cname,String cadmin){
        Random random = new Random();
        int result = jdbcTemplate.queryForObject("SELECT UserID FROM User where Email = ?", Integer.class, cadmin);
        String sql2 = "INSERT INTO Community (CommunityID,Name, CreatorUserID, InviteCode, logo,Description) VALUES (?,?, ?, ?,?,?)";

        // Create a KeyHolder to capture the generated user_id
        KeyHolder keyHolder2 = new GeneratedKeyHolder();

        // Execute the insert and capture the generated user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, CourseId);
            ps.setString(2, cname);
            ps.setInt(3, result);
            ps.setInt(4, random.nextInt(90000) + 10000);
            ps.setString(5, "__");
            ps.setString(6, "__");
            return ps;
        }, keyHolder2);
        int id = keyHolder2.getKey().intValue();
        return id;

    }
    public int addUsertoComm(int CourseId,int UserId){
        String sql2 = "INSERT INTO CommunityMember (UserID,CommunityID) VALUES (?,?)";

        // Create a KeyHolder to capture the generated user_id
        KeyHolder keyHolder2 = new GeneratedKeyHolder();

        // Execute the insert and capture the generated user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, UserId);
            ps.setInt(2, CourseId);
            return ps;
        }, keyHolder2);
        int id = keyHolder2.getKey().intValue();
        return id;
    }
    public int addChannelToComm(String Name,int CourseId,int tid){
        String sql2 = "INSERT INTO Channel (Name,CommunityID,CreatorUserID) VALUES (?,?,?)";

        // Create a KeyHolder to capture the generated user_id
        KeyHolder keyHolder2 = new GeneratedKeyHolder();

        // Execute the insert and capture the generated user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Name);
            ps.setInt(2, CourseId);
            ps.setInt(3, tid);

            return ps;
        }, keyHolder2);
        int id = keyHolder2.getKey().intValue();
        return id;
    }

}
