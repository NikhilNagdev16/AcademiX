package com.academix.academix.services;

import com.academix.academix.data.CourseDataService;
import com.academix.academix.model.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServiceInterface {

    @Autowired
    CourseDataService courseDAO;

    @Override
    public course getCourseById(int id) {
        return courseDAO.getCourseById(id);
    }

    @Override
    public List<course> getCourseByCollegeId(int id) {
        return courseDAO.getCourseByCollegeId(id);
    }

    @Override
    public int addCourse(course c) {
        return courseDAO.addCourse(c);
    }
}
