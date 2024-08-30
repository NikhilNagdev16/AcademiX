package com.academix.academix.data;

import com.academix.academix.model.loginInfo;
import com.academix.academix.model.users;
import com.academix.academix.model.usersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class UsersDataService implements UsersDataAccessInterface{

    JdbcTemplate jdbcTemplate;
    @Autowired
    public UsersDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;


    @Override
    public int addusers(users user,int collegeid) {

        String sql = "INSERT INTO users (password, email, name,role) VALUES (?, ?, ?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getName());
            ps.setString(4, user.getRole());
            return ps;
        }, keyHolder);

        String sql1="insert into user_college(user_id,college_id) values(?,?)";
        KeyHolder keyHolder1 = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, keyHolder1.getKey().intValue());
            ps.setInt(2, collegeid);
            return ps;
        },keyHolder);
        return keyHolder.getKey().intValue();

    }

    @Override
    public users getUserById(int id) {
        List<users> result = jdbcTemplate.query("select * from users where user_id=?", new usersMapper(),id);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<users> getAllUsers() {
        return jdbcTemplate.query("select * from users", new usersMapper());
    }

    @Override
    public int adduser(users newuser) {
        return jdbcTemplate.update("INSERT Into users(email,password,role,name) values (?,?,?,?)",
                                              newuser.getEmail(),newuser.getPassword(),newuser.getRole(),newuser.getName());
    }

    @Override
    public loginInfo getLogininfo(String username, String Password) {
        List<users> users=jdbcTemplate.query("select * from users where email =?",new usersMapper(),username);
        if(users.isEmpty()){
            return null;
        }
        int userID=users.get(0).getUser_id();
        String name=users.get(0).getName();
        String role=users.get(0).getRole();
        int collegeID;

            List<Integer> clgid = jdbcTemplate.query(
                    "select college_id from user_college where user_id=?",
                    new Object[]{userID},
                    (rs, rowNum) -> rs.getInt("college_id")
            );

            if (!clgid.isEmpty()) {
                collegeID = clgid.get(0);
            } else {
                collegeID = -1;
            }

        return new loginInfo(userID,name,role,collegeID);
    }

    public String login(String username, String password) {
        List<users> users=jdbcTemplate.query("select * from users where email =?",new usersMapper(),username);
        if(users.isEmpty()){
            return "nf";
        }
        users user=users.get(0);
        if(user.getPassword().equals(password)){
            return user.getRole();
        } else {
            return "ip";
        }

    }
}
