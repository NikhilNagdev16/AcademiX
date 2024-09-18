package com.academix.academix.services;

import com.academix.academix.data.ScheduleDataService;
import com.academix.academix.model.schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class scheduleService implements ScheduleServiceInterface {

    @Autowired
    ScheduleDataService scheduleDAO;

    @Override
    public int addSchedule(schedule s) {
        return  scheduleDAO.addSchedule(s);
    }

    @Override
    public List<schedule> getByCourse(int courseId) {
        List<schedule> schedules = scheduleDAO.getByCourse(courseId);
        return schedules;
    }

    @Override
    public List<schedule> getBySubject(int subjectId) {
        List<schedule> schedules = scheduleDAO.getBySubject(subjectId);
        return schedules;
    }

    @Override
    public List<schedule> getByTeacher(int teacherId) {
        return scheduleDAO.getByTeacher(teacherId);
    }

    @Override
    public List<schedule> getAllSchedules() {
        List<schedule> schedules = scheduleDAO.getAllSchedules();
        return schedules;
    }

    public List<schedule> getscheduleforattendance(int subjectId, String dayofweek) {
        List<schedule> schedules = scheduleDAO.getscheduleforattendance(subjectId,dayofweek);
        return schedules;
    }
}
