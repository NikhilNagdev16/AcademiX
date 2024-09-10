package com.academix.academix.services;

import com.academix.academix.data.CollegeDataService;
import com.academix.academix.data.GeneralDataService;
import com.academix.academix.model.colleges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServices implements CollegeServiceInterface {

    CollegeDataService CollegeDAO;
    @Autowired
    public CollegeServices(CollegeDataService CollegeDAO) {
        this.CollegeDAO = CollegeDAO;
    }

    @Override
    public int addCollege(colleges clgInfo) {
        return CollegeDAO.addCollege(clgInfo);
    }

    @Override
    public List<colleges> getAllColleges() {
        return CollegeDAO.getAllColleges();
    }

    @Override
    public colleges getCollegeById(int id) {
        return CollegeDAO.getCollegeById(id);
    }


}
