package com.academix.academix.services;

import com.academix.academix.model.course;

import java.util.List;

public interface CourseServiceInterface {
    public course getCourseById(int id);
    public List<course> getCourseByCollegeId(int id);
    public int addCourse(course c);
}
