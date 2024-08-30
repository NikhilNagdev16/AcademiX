package com.academix.academix.data;

import com.academix.academix.model.loginInfo;
import com.academix.academix.model.users;

import java.util.List;

public interface UsersDataAccessInterface {
    public int addusers(users users,int collegeid);
    public users getUserById(int id);
    public List<users> getAllUsers();
    public int adduser(users newuser);
    public loginInfo getLogininfo(String username , String Password);
}
