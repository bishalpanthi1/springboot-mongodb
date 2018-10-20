package com.rest.mongo.service;

import com.rest.mongo.document.StudentDocument;

import java.util.List;

public interface StudentService {
    void create(StudentDocument studentDocument);

    void update(StudentDocument studentDocument);

    StudentDocument findByEmail(String email);

    List<StudentDocument>  findAll();
}
