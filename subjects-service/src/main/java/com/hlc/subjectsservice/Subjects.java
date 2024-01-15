package com.hlc.subjectsservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

public interface Subjects {
    @GetMapping("/subjects")
    List<Subject> getAllSubjects();
    @GetMapping("/subjects")
    Optional<Subject> findById(String id);
    @PostMapping("/subjects")
    Subject save(Subject subject);

    @DeleteMapping("/subjects")
    void deleteById(String id);

    @PutMapping("/subjects")
    void update(Subject subject);

}
