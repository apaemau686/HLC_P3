
package com.hlc.studentsservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepository extends MongoRepository<Student, String> {

    // Método para buscar todos los estudiantes
    List<Student> findAll();
}
