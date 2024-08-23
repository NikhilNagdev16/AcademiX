package com.academix.academix.services;

import com.academix.academix.model.loginInfo;
import com.academix.academix.model.users;

import java.util.List;

public interface userServiceInterface {
    public int addusers(users users);
    public users getUserById(int id);
    public List<users> getAllUsers();
    public int createUser(users user);
    public loginInfo getLoginInfo(String username, String password);
}
