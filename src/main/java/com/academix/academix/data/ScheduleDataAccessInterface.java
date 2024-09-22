package com.academix.academix.data;

import com.academix.academix.model.schedule;

import java.util.List;

public interface ScheduleDataAccessInterface {
    public int addSchedule(schedule s);
    List<schedule> getByCourse(int courseId);
    List<schedule> getBySubject(int subjectId);
    List<schedule> getByTeacher(int teacherId);
    List<schedule> getAllSchedules();
    List<schedule> getScheduleForAttendance(int subjectId, String day);
    List<schedule> getByStudent(int studentId);
}
