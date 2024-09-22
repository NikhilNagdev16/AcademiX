package com.academix.academix.controllers;

import com.academix.academix.model.examModel;
import com.academix.academix.services.ExamMarks;
import com.academix.academix.services.examServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class examController {

    @Autowired
    examServices es;

    @PostMapping("/markExam")
    public int MarkExam(@RequestParam int subjectId,@RequestBody List<examModel> em)
    {
        return es.MarkExam(subjectId,em);
    }

    @GetMapping("studentMarks")
    public List<ExamMarks> getExamMarksByUserId(int userId)
    {
        return es.getExamMarksByUserId(userId);
    }

}
