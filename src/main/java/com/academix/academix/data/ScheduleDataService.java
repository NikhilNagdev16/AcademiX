package com.academix.academix.data;

import com.academix.academix.model.schedule;
import com.academix.academix.model.scheduleMapper;
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
public class ScheduleDataService implements ScheduleDataAccessInterface{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addSchedule(schedule s) {
        String sql = "INSERT INTO schedules (course_id, subject_id,  day,start_time,end_time,classno)" +
                " VALUES (?, ?, ?, ?,?, ?)";

        // Create a KeyHolder to capture the generated user_id
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Execute the insert and capture the generated user_id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,s.getCourse_id());
            ps.setInt(2,s.getSubject_id());
            ps.setString(3,s.getDay());
            ps.setString(4,s.getStart_time());
            ps.setString(5,s.getEnd_time());
            ps.setInt(6,s.getClass_no());
            return ps;
        }, keyHolder);

        // Extract the generated user_id
        int scheduleId = keyHolder.getKey().intValue();
        return scheduleId;
    }

    @Override
    public List<schedule> getByCourse(int courseId) {
        List<schedule> result = jdbcTemplate.query("select * from schedules where course_id=?", new scheduleMapper(),courseId);
        return result;
    }

    @Override
    public List<schedule> getBySubject(int subjectId) {
        List<schedule> result = jdbcTemplate.query("select * from schedules where subject_id=?", new scheduleMapper(),subjectId);
        return result;
    }

    @Override
    public List<schedule> getByTeacher(int teacherId) {

        List<schedule> schedules = jdbcTemplate.query(
//                select s.* ,sb.subject_name,c.course_name from schedules s Join subjects sb on s.subject_id = sb.subject_id join courses c on c.course_id = sb.course_id where sb.Teacher_id=7;
                "select s.* from schedules s Join subjects sb on s.subject_id = sb.subject_id  where sb.Teacher_id=? ",
                new scheduleMapper(),
                teacherId
        );
        return schedules;
    }

    @Override
    public List<schedule> getAllSchedules() {
        List<schedule> result = jdbcTemplate.query("select * from schedules", new scheduleMapper());
        return result;
    }


    public List<schedule> getscheduleforattendance(int subjectId, String dayofweek) {

        List<schedule> result = jdbcTemplate.query("select * from schedules where subject_id=?&day=?", new scheduleMapper(),subjectId,dayofweek);
        return result;
    }
}
