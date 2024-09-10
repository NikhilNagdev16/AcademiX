package com.academix.academix.data;

import com.academix.academix.model.loginInfo;
import com.academix.academix.model.userPass;
import com.academix.academix.model.users;

import java.util.List;

public interface UsersDataAccessInterface {
    public int addusers(users users,int collegeid);
    public int addStudent(users users,int collegeid,int course_id,int roll_no);
    public users getUserById(int id);
    public List<users> getAllUsers();
    public void forgotPass(String email);
    public List<users> getTeachers(int collegeid);
    public loginInfo getLogininfo(String username , String Password);
}
