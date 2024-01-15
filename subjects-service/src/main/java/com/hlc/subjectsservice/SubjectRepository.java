package com.hlc.subjectsservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends MongoRepository<Subject, String> {
    // Método para buscar todas las asignaturas
    List<Subject> findAll();

    // Método para buscar por id
    Optional<Subject> findById(String id);

    // Método para añadir una asignatura
    Subject save(Subject subject);

    // Método para eliminar una asignatura
    void deleteById(String id);

    // Método para editar una asignatura
    void update(Subject subject);
}
