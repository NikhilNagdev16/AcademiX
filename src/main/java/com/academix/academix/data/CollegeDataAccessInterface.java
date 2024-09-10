package com.academix.academix.data;

import com.academix.academix.model.colleges;

import java.util.List;

public interface CollegeDataAccessInterface {
    public int addCollege(colleges clgInfo);
    public List<colleges> getAllColleges();
    public colleges getCollegeById(int id);
}
