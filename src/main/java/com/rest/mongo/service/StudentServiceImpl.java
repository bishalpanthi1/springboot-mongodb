package com.rest.mongo.service;

import com.rest.mongo.document.StudentDocument;
import com.rest.mongo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private NextSequenceService nextSequenceService;

    public StudentServiceImpl(StudentRepository studentRepository, NextSequenceService nextSequenceService) {
        this.studentRepository = studentRepository;
        this.nextSequenceService = nextSequenceService;
    }

    @Override
    public void create(StudentDocument studentDocument) {
        studentDocument.setId(nextSequenceService.getNextSequenceId("student"));
        studentRepository.insert(studentDocument);
    }

    @Override
    public void update(StudentDocument studentDocument) {
        studentRepository.save(studentDocument);
    }

    @Override
    public StudentDocument findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<StudentDocument> findAll() {
        return studentRepository.findAll();
    }
}
