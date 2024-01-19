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

    @GetMapping("/subjects/{code}")
    public Subject getSubjectByCode(@PathVariable String code) {
        return subjectRepository.findByCode(code);
    }

    @PostMapping("/subjects")
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/subjects/{code}")
    public Subject updateSubjectByCode(@PathVariable String code, @RequestBody Subject updatedSubject) {
        Subject existingSubject = subjectRepository.findByCode(code);
        if (existingSubject != null) {
            existingSubject.setName(updatedSubject.getName());
            existingSubject.setHours(updatedSubject.getHours());
            return subjectRepository.save(existingSubject);
        } else {
            // Manejar el caso en el que la asignatura con el código proporcionado no existe
            return null;
        }
    }

    @DeleteMapping("/subjects/{code}")
    public void deleteSubjectByCode(@PathVariable String code) {
        subjectRepository.deleteByCode(code);
    }
}
