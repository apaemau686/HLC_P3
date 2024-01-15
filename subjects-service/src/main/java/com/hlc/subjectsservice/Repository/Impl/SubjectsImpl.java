package com.hlc.subjectsservice.Repository.Impl;

import com.hlc.subjectsservice.Repository.SubjectRepository;
import com.hlc.subjectsservice.Subject;
import com.hlc.subjectsservice.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectsImpl implements Subjects {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }
}
