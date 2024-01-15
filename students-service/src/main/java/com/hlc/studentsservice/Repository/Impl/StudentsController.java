package com.hlc.studentsservice.Repository.Impl;

import com.hlc.studentsservice.Repository.Impl.StudentRepository;
import com.hlc.studentsservice.Student;
import com.hlc.studentsservice.SubjectsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentsController {
    @Autowired
    private SubjectsClient subjectsClient;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/subjectsForStudents")
    public String getSubjectsforStudents(){
        List<String> subjects = subjectsClient.getAllSubjects();
        return "Students can enroll at " + subjects.size() + " subjects.";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> prueba = studentRepository.findAll();
        System.out.println(prueba);
        return studentRepository.findAll();
    }
}
