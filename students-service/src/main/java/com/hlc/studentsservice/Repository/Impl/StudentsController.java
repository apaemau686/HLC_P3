package com.hlc.studentsservice.Repository.Impl;

import com.hlc.studentsservice.Repository.Impl.StudentRepository;
import com.hlc.studentsservice.Student;
import com.hlc.studentsservice.SubjectsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable String id){
        return studentRepository.findById(id);
    }

    @PostMapping("/students")
    public Student save(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudentById(@PathVariable String id){
        try {
            studentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/students")
    public ResponseEntity deleteAllStudent(){
        try {
            studentRepository.deleteAll();
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }
}
