package com.academix.academix.controllers;

import com.academix.academix.model.loginInfo;
import com.academix.academix.model.userPass;
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

    @GetMapping("/getTeacher")
    public List<users> getTeacher(@RequestParam int collegeId){
        return usersService.getTeachers(collegeId);
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
    public int addUser(@RequestBody users user, @RequestParam int collegeid) {
        return usersService.addusers(user,collegeid);
    }

    @PostMapping("/addStudent")
    public int addStudent(@RequestBody users user, @RequestParam int collegeid, @RequestParam int course_id, @RequestParam int roll_no) {
        return usersService.addStudent(user,collegeid,course_id,roll_no);
    }

    @GetMapping("/forgot")
    public void forgotUser(@RequestParam String email) {
        usersService.forgotPass(email);
    }

}
