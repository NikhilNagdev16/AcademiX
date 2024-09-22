package com.academix.academix.data;

import com.academix.academix.model.CollegeMapper;
import com.academix.academix.model.colleges;
import com.academix.academix.model.course;
import com.academix.academix.model.courseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CourseDataService implements CourseDataAccessInterface{
    JdbcTemplate jdbcTemplate;
    @Autowired
    public CourseDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    GeneralDataService gds;

    @Autowired
    CollegifyDataServices cds;

    @Override
    public course getCourseById(int id) {
        List<course> result = jdbcTemplate.query("Select * from courses where course_id =?",new courseMapper(),id);
        if(result.size()>0){
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<course> getCourseByCollegeId(int id) {
        List<course> result = jdbcTemplate.query("Select * from courses where college_id =?",new courseMapper(),id);

        return result;
    }

    @Override
    public int addCourse(course c) {
        String sql = "INSERT INTO courses (college_id,course_name,semesters,active_semester) VALUES (?, ?, ?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getCollege_id());
            ps.setString(2, c.getCourse_name());
            ps.setInt(3, c.getSemesters());
            ps.setInt(4, c.getActive_semester());

            return ps;
        }, keyHolder);
           int k=keyHolder.getKey().intValue();
          cds.CreateComm(k,c.getCourse_name(),gds.getAdminEmail(c.getCollege_id()));
        return k;
    }
}
