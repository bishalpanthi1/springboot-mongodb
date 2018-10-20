package com.rest.mongo.repository;

import com.rest.mongo.document.StudentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentDocument,Long> {

   StudentDocument findByEmail(String email);
}
