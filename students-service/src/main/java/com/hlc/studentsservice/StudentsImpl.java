// StudentsImpl.java
package com.hlc.studentsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentsImpl implements Students {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("Students: " + students);
        return students;
    }
}
