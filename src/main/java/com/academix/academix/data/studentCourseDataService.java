package com.academix.academix.data;

import com.academix.academix.model.CollegeMapper;
import com.academix.academix.model.colleges;
import com.academix.academix.model.studentCourse;
import com.academix.academix.model.studentCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class studentCourseDataService implements studentCourseDataInterface{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<studentCourse> getStudentsByCourseId(int courseId) {
        List<studentCourse> result = jdbcTemplate.query("select s.student_id,u.name,s.roll_no from student_course s join users u on s.student_id=u.user_id where s.course_id=? ",new studentCourseMapper(),courseId);
        return result;

    }

    public List<studentCourse> getStudentsBySubjectId(int subjectId) {
        String sql = "SELECT s.student_id, u.name, s.roll_no " +
                "FROM student_course s " +
                "JOIN users u ON s.student_id = u.user_id " +
                "JOIN subjects sb ON s.course_id = sb.course_id " +
                "WHERE sb.subject_id = ?";

        List<studentCourse> result = jdbcTemplate.query(sql, new studentCourseMapper(), subjectId);
        return result;
    }
}
