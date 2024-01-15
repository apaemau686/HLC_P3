package com.hlc.studentsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class StudentImpl implements Students{
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/subjects")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
