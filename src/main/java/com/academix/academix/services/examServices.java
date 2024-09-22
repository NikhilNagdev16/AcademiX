package com.academix.academix.services;

import com.academix.academix.data.ExamDataService;
import com.academix.academix.model.examModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class examServices {

    @Autowired
    ExamDataService examDao;

    public int MarkExam(int subjectId, List<examModel> em){
        return examDao.MarkExam(subjectId,em);
    }
    public List<ExamMarks> getExamMarksByUserId(int userId){
        return examDao.getExamMarksByUserId(userId);
    }
}
