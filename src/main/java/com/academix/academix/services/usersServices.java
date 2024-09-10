
package com.academix.academix.services;

import com.academix.academix.data.UsersDataService;
import com.academix.academix.model.loginInfo;
import com.academix.academix.model.userPass;
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
    public int addusers(users users,int collegeid) {
        return userDAO.addusers(users,collegeid);
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
    public  void forgotPass(String email) {
        userDAO.forgotPass(email);
    }

    @Override
    public List<users> getTeachers(int collegeid) {
        return userDAO.getTeachers(collegeid);
    }

    @Override
    public int addStudent(users users, int collegeid, int course_id, int roll_no) {
        return userDAO.addStudent(users,collegeid,course_id,roll_no);
    }

    @Override
    public loginInfo getLoginInfo(String username, String password) {
        return userDAO.getLogininfo(username, password);
    }

    public String login(String username, String password) {
        return userDAO.login(username, password);
    }
}