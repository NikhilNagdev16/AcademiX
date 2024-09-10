package com.academix.academix.services;

import com.academix.academix.model.schedule;

import java.util.List;

public interface ScheduleServiceInterface {
    public int addSchedule(schedule s);
    List<schedule> getByCourse(int courseId);
    List<schedule> getBySubject(int subjectId);
    List<schedule> getByTeacher(int teacherId);
    List<schedule> getAllSchedules();
}
