package com.academix.academix.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralDataService implements GeneralDataServiceInterface {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public GeneralDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getCollegeName(int collegeID) {
        String result = jdbcTemplate.queryForObject("SELECT college_name FROM colleges WHERE college_id = ?", String.class, collegeID);
        return result;
    }

    @Override
    public String getCollegeLogo(int collegeID) {
        String result = jdbcTemplate.queryForObject("SELECT college_logo FROM colleges WHERE college_id = ?", String.class, collegeID);
        return result;
    }

    @Override
    public int noOfUsers() {
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USERS", Integer.class);
        return result;
    }

    @Override
    public int noOfUsers(int collegeID) {
        int result = jdbcTemplate.queryForObject("select count(*) from user_college where college_id = ?", Integer.class, collegeID);
        return result;
    }

    @Override
    public int noOfColleges() {
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM colleges", Integer.class);
        return result;
    }

    @Override
    public int noOfCourses(int collegeID) {
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM courses WHERE college_id = ?", Integer.class, collegeID);
        return result;
    }

    @Override
    public int noOfStudents(int collegeID) {
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user_college uc " + "JOIN users u ON uc.user_id = u.user_id " + "WHERE uc.college_id = ? AND u.role = 'student'", Integer.class, collegeID);
        return result;
    }

    @Override
    public int noOfTeachers(int collegeID) {
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user_college uc " + "JOIN users u ON uc.user_id = u.user_id " + "WHERE uc.college_id = ? AND u.role = 'teacher'", Integer.class, collegeID);
        return result;
    }

    @Override
    public int noOfLectures(int studentID) {
        //todo
        return 0;
    }
}
