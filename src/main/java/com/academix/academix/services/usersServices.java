
package com.academix.academix.services;

import com.academix.academix.data.UsersDataService;
import com.academix.academix.model.loginInfo;
import com.academix.academix.model.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersServices implements userServiceInterface {

    // Inject UsersDataService using @Autowired
    private final UsersDataService userDAO;

    @Autowired
    public usersServices(UsersDataService userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public int addusers(users users) {
        return userDAO.addusers(users);
    }

    @Override
    public users getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<users> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public int createUser(users user) {
        return userDAO.adduser(user);
    }

    @Override
    public loginInfo getLoginInfo(String username, String password) {
        return userDAO.getLogininfo(username, password);
    }

    public String login(String username, String password) {
        return userDAO.login(username, password);
    }
}