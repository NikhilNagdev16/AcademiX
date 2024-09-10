package com.academix.academix.controllers;

import com.academix.academix.model.colleges;
import com.academix.academix.model.userCollege;
import com.academix.academix.services.CollegeServices;
import com.academix.academix.services.usersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class collegeController {

    @Autowired
    CollegeServices collegeServices;
    @Autowired
    usersServices usersService;

    @PostMapping("/addCollege")
    public int addCollege(@RequestBody userCollege uc){
        System.out.println("here"+uc.getUser());
           return usersService.addusers(uc.getUser(),collegeServices.addCollege(uc.getCollege()));
        }
    @GetMapping("/colleges")
    public List<colleges> getAllCollege(){
        return collegeServices.getAllColleges();
    }
    @GetMapping("/getCollege")
    public colleges getCollege(@RequestParam int id){
        return collegeServices.getCollegeById(id);
    }
}
