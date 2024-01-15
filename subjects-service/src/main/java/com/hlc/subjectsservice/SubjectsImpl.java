package com.hlc.subjectsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectsImpl implements Subjects{

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    @GetMapping("/subjects")
    public Optional<Subject> findById(String id){
        return subjectRepository.findById(id);
    }

    @Override
    @PostMapping("/subjects")
    public Subject save(Subject subject){
        return subjectRepository.insert(subject);
    }

    @Override
    @DeleteMapping("/subjects")
    public void deleteById(String id){
        subjectRepository.deleteById(id);
    }

    @Override
    @PutMapping("/subjects")
    public void update(Subject subject){
        if (!findById(subject.getId()).isEmpty()){
            deleteById(subject.getId());
        }
        save(subject);
    }
}
