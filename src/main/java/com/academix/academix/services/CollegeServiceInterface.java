package com.academix.academix.services;

import com.academix.academix.model.colleges;

import java.util.List;

public interface CollegeServiceInterface {
    public int addCollege(colleges clgInfo);
    public List<colleges> getAllColleges();
    public colleges getCollegeById(int id);
}
