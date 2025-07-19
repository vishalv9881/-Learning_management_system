package com.example.student_mangement.controller;

import com.example.student_mangement.dto.StudentRequestDto;
import com.example.student_mangement.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentRequestDto studentRequestDto) {
        logger.info("=== REGISTRATION REQUEST RECEIVED ===");
        logger.info("Student Name: {}", studentRequestDto.getStudentName());
        logger.info("Student Email: {}", studentRequestDto.getEmail());
        logger.info("Student Gender: {}", studentRequestDto.getStudentGender());

        try {
            String result = studentService.registerStudent(studentRequestDto);
            logger.info("Registration successful: {}", result);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Registration failed with error: ", e);
            return ResponseEntity.internalServerError().body("Registration failed: " + e.getMessage());
        }
    }
}