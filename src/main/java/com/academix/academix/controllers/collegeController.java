package com.academix.academix.controllers;

import com.academix.academix.model.userCollege;
import com.academix.academix.services.CollegeServices;
import com.academix.academix.services.usersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class collegeController {

    @Autowired
    CollegeServices collegeServices;
    @Autowired
    usersServices usersService;

    @PostMapping("/addCollege")
    public int addCollege(@RequestBody userCollege uc){
           return usersService.addusers(uc.getUser(),collegeServices.addCollege(uc.getCollege()));
        }
}
