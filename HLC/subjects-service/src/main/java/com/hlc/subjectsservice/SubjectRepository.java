package com.hlc.subjectsservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {

    List<Subject> findAll();

    Subject findByCode(String code);

    List<Subject> findByName(String name);

    // No se necesita un método updateByCode, utilizaremos save para actualizar

    void deleteByCode(String code);
}
