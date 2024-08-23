package com.academix.academix.data;

public interface GeneralDataServiceInterface {
    public String getCollegeName(int collegeID);
    public String getCollegeLogo(int collegeID);
    public int noOfUsers();
    public int noOfUsers(int collegeID);
    public int noOfColleges();
    public int noOfCourses(int collegeID);
    public int noOfStudents(int collegeID);
    public int noOfTeachers(int collegeID);
    public int noOfLectures(int studentID);
}
