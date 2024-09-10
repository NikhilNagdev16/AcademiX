package com.academix.academix.data;

import com.academix.academix.model.subject;
import com.academix.academix.model.subjectMapper;
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
public class SubjectDataService implements SubjectDataAccessInterface{
    JdbcTemplate jdbcTemplate;
    @Autowired
    public SubjectDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int createSubject(subject sub) {
        String sql = "INSERT INTO subjects (course_id, semester, subject_name, Teacher_id,internal_marks,external_marks,practical_marks) VALUES (?, ?, ?, ?,?, ?, ?)";

        // Create a KeyHolder to capture the generated user_id
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Execute the insert and capture the generated user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, sub.getCourse_id());
            ps.setInt(2, sub.getSemester());
            ps.setString(3,sub.getSubject_name());
            ps.setInt(4, sub.getTeacherId());
            ps.setInt(5, sub.getInternal_marks());
            ps.setInt(6, sub.getExternal_marks());
            ps.setInt(7, sub.getPractical_marks());
            return ps;
        }, keyHolder);

        // Extract the generated user_id
        int subjectid = keyHolder.getKey().intValue();
        return subjectid;
    }

    @Override
    public List<subject> getAllSubjects(int courseId) {
        List<subject> result = jdbcTemplate.query("select * from subjects where course_id=?", new subjectMapper(),courseId);
        return result;
    }
}
