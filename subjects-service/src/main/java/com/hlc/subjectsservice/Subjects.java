package com.hlc.subjectsservice;

import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface Subjects {
    @GetMapping("/subjects")
    List<Subject> getAllSubjects();

    @GetMapping("/subjects/{id}")
    Subject getSubjectById(@PathVariable String id);

    @PostMapping("/subjects")
    Subject createSubject(@RequestBody Subject subject);

    @PutMapping("/subjects/{id}")
    Subject updateSubject(@PathVariable String id, @RequestBody Subject subject);

    @DeleteMapping("/subjects/{id}")
    void deleteSubject(@PathVariable String id);
}
