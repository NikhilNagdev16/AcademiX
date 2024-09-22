package com.academix.academix.data;

import com.academix.academix.model.studentCourse;

import java.util.List;

public interface studentCourseDataInterface {
    public List<studentCourse> getStudentsByCourseId(int courseId);
}
