package com.hlc.subjectsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SubjectsImpl implements Subjects {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @GetMapping("/subjects/{id}")
    public Subject getSubjectById(@PathVariable java.lang.String id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @PostMapping("/subjects")
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/subjects/{id}")
    public Subject updateSubject(@PathVariable String id, @RequestBody Subject updatedSubject) {
        Subject existingSubject = subjectRepository.findById(id).orElse(null);

        if (existingSubject != null) {
            existingSubject.setCode(updatedSubject.getCode());
            existingSubject.setName(updatedSubject.getName());
            existingSubject.setHours(updatedSubject.getHours());

            return subjectRepository.save(existingSubject);
        }

        return null;
    }

    @DeleteMapping("/subjects/{id}")
    public void deleteSubject(@PathVariable String id) {
        subjectRepository.deleteById(id);
    }
}
