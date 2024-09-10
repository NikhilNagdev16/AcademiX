package com.academix.academix.services;

import com.academix.academix.data.GeneralDataService;
import com.academix.academix.model.collegeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralServices implements GeneralServicesInterface{
    GeneralDataService generalDAO;
    @Autowired
    public GeneralServices(GeneralDataService generalDAO) {
        this.generalDAO = generalDAO;
    }

    public collegeInfo getCollegeInfo(int collegeID){
        collegeInfo clginfo = new collegeInfo(noOfUsers(collegeID),getCollegeName(collegeID),getCollegeLogo(collegeID),noOfStudents(collegeID),noOfCourses(collegeID),noOfTeachers(collegeID));
        return clginfo;
    }

    @Override
    public String getCollegeName(int collegeID) {
        return generalDAO.getCollegeName(collegeID);
    }

    @Override
    public String getCollegeLogo(int collegeID) {
        return generalDAO.getCollegeLogo(collegeID);
    }

    @Override
    public int noOfUsers() {
        return generalDAO.noOfUsers();
    }

    @Override
    public int noOfUsers(int collegeID) {
        return generalDAO.noOfUsers(collegeID);
    }

    @Override
    public int noOfColleges() {
        return generalDAO.noOfColleges();
    }

    @Override
    public int noOfCourses(int collegeID) {
        return generalDAO.noOfCourses(collegeID);
    }

    @Override
    public int noOfStudents(int collegeID) {
        return generalDAO.noOfStudents(collegeID);
    }

    @Override
    public int noOfTeachers(int collegeID) {
        return generalDAO.noOfTeachers(collegeID);
    }

    @Override
    public int noOfLecturesTeacher(int teacherId) {
        return generalDAO.noOfLecturesTeacher(teacherId);
    }

    @Override
    public int noOfLecturesStudent(int studentId) {
        return generalDAO.noOfLecturesStudent(studentId);
    }

    @Override
    public int noOfSubjectsTeacher(int teacherId) {
        return generalDAO.noOfSubjectsTeacher(teacherId);
    }


}
