package com.academix.academix.data;

import com.academix.academix.model.course;

import java.util.List;

public interface CourseDataAccessInterface {
    public course getCourseById(int id);
    public List<course> getCourseByCollegeId(int id);
    public int addCourse(course c);
}
