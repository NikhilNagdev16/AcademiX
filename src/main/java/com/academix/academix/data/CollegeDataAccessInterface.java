package com.academix.academix.data;

import com.academix.academix.model.colleges;

public interface CollegeDataAccessInterface {
    public int addCollege(colleges clgInfo);
    public colleges getCollegeById(int id);
}
