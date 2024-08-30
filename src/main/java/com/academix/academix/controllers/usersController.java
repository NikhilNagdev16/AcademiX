package com.academix.academix.controllers;

import com.academix.academix.model.loginInfo;
import com.academix.academix.model.users;
import com.academix.academix.services.CollegeServices;
import com.academix.academix.services.usersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class usersController {

    @Autowired
    usersServices usersService;
    @Autowired
    private CollegeServices collegeServices;

    @GetMapping("/users")
    public List<users> getUsers(){
        return usersService.getAllUsers();
    }
    
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/userbyid")
    public users getUserById(@RequestParam int id) {
       users user=usersService.getUserById(id);
       return user;
    }
    @PostMapping("/login")
    public loginInfo login(@RequestParam String username, @RequestParam String password) {
        return usersService.getLoginInfo(username, password);
    }
    @PostMapping("/addUser")
    public int addUser(@RequestBody users user, int collegeid) {
        return usersService.addusers(user,collegeid);
    }

}
