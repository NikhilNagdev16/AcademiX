package com.academix.academix.data;

import com.academix.academix.model.CollegeMapper;
import com.academix.academix.model.colleges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CollegeDataService implements CollegeDataAccessInterface{

    JdbcTemplate jdbcTemplate;
    @Autowired
    public CollegeDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addCollege(colleges clgInfo) {
        String sql = "INSERT INTO colleges (college_name,no_of_classes,address,email,phone,college_logo) VALUES (?, ?, ?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, clgInfo.getCollege_name());
            ps.setInt(2, clgInfo.getNoOfClasses());
            ps.setString(3, clgInfo.getCollege_address());
            ps.setString(4, clgInfo.getCollege_email());
            ps.setString(5, clgInfo.getCollege_phone());
            ps.setString(6, clgInfo.getLogo());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public colleges getCollegeById(int id) {
        List<colleges> result = jdbcTemplate.query("Select * from Colleges where college_id =?",new CollegeMapper(),id);
        if(result.size()>0){
            return result.get(0);
        }
        return null;
    }
}
