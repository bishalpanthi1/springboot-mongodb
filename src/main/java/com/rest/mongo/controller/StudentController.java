package com.rest.mongo.controller;

import com.rest.mongo.document.StudentDocument;
import com.rest.mongo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("student")
    public ResponseEntity create(@RequestBody StudentDocument studentDocument){
        studentService.create(studentDocument);
        return new ResponseEntity("Success", HttpStatus.CREATED);
    }

    @PutMapping("student")
    public ResponseEntity update(@RequestBody StudentDocument studentDocument){
        studentService.update(studentDocument);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @GetMapping("student/{email}")
    public ResponseEntity<StudentDocument> findByEmail(@PathVariable String email){
        return new ResponseEntity<>(studentService.findByEmail(email),HttpStatus.OK);
    }

    @GetMapping("students")
    public ResponseEntity<List<StudentDocument>> findAll(){
        return new ResponseEntity<>(studentService.findAll(),HttpStatus.OK);
    }
}
