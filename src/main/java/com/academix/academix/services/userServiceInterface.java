package com.academix.academix.services;

import com.academix.academix.model.loginInfo;
import com.academix.academix.model.userPass;
import com.academix.academix.model.users;

import java.util.List;

public interface userServiceInterface {
    public int addusers(users users,int collegeid);
    public users getUserById(int id);
    public List<users> getAllUsers();
    public void forgotPass(String email);
    public List<users> getTeachers(int collegeid);
    public int addStudent(users users, int collegeid, int course_id, int roll_no);
    public loginInfo getLoginInfo(String username, String password);
}
