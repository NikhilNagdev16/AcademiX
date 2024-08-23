package com.academix.academix.services;

import com.academix.academix.model.colleges;

public interface CollegeServiceInterface {
    public int addCollege(colleges clgInfo);
    public colleges getCollegeById(int id);
}
