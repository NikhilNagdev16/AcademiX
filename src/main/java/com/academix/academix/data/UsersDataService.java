package com.academix.academix.data;

import com.academix.academix.model.loginInfo;
import com.academix.academix.model.userPass;
import com.academix.academix.model.users;
import com.academix.academix.model.usersMapper;
import com.academix.academix.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Autowired
    EmailService es;

    @Autowired
    CollegifyDataServices cds;
    @Override
    public int addusers(users user, int collegeid) {

        // SQL query to insert into the users table
        String sql = "INSERT INTO users (password, email, name, role) VALUES (?, ?, ?, ?)";

        // Create a KeyHolder to capture the generated user_id
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Execute the insert and capture the generated user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getName());
            ps.setString(4, user.getRole());
            return ps;
        }, keyHolder);

        // Extract the generated user_id
        int userId = keyHolder.getKey().intValue();

        // SQL query to insert into the user_college table
        String sql1 = "INSERT INTO user_college (user_id, college_id) VALUES (?, ?)";

        // Execute the insert into user_college table with the captured user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, userId);
            ps.setInt(2, collegeid);
            return ps;
        });

        cds.addUser(user,userId);

        // Return the generated user_id
        return userId;
    }

    @Override
    public int addStudent(users users, int collegeid, int course_id, int roll_no) {
        int stuId = addusers(users, collegeid);

        String sql1 = "INSERT INTO student_course (course_id, student_id,roll_no) VALUES (?, ?,?)";

        // Execute the insert into user_college table with the captured user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, course_id);
            ps.setInt(2, stuId);
            ps.setInt(3, roll_no);
            return ps;
        });
        cds.addUsertoComm(course_id,stuId);
        return stuId;

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
    public void forgotPass(String email) {
        List<users> users=jdbcTemplate.query("select * from users where email =?",new usersMapper(),email);
        if(users.isEmpty()){
            return ;
        }
        String username=users.get(0).getEmail();
        String password=users.get(0).getPassword();
        es.sendCredentials(username,username,password);
    }

    @Override
    public List<users> getTeachers(int collegeid) {
        List<users> users=jdbcTemplate.query("SELECT *" +
                "FROM users u\n" +
                "JOIN user_college uc ON u.user_id = uc.user_id\n" +
                "WHERE uc.college_id = ?;",new usersMapper(),collegeid);
        return users;
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
