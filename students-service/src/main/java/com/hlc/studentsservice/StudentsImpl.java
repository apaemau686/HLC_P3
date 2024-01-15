package com.hlc.studentsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsImpl {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = studentsRepository.findAll();
        // Log or print the students list to check the birthDate field
        System.out.println(students);
        return students;
    }
}