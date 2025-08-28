package com.example.student_mangement.controller;

import com.example.student_mangement.dto.CourseResponseDto;
import com.example.student_mangement.dto.StudentRequestDto;
import com.example.student_mangement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentRequestDto studentRequestDto) {
        System.out.println("Received DTO: " + studentRequestDto);  // 👈 log input
        String result = studentService.registerStudent(studentRequestDto);
        return ResponseEntity.ok(result);
    }



    // ==============================
    // Get all courses from Course Service
    // ==============================
    @GetMapping("/All/courses")
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        try {
            List<CourseResponseDto> courses = (List<CourseResponseDto>) studentService.getAllCourses();
            return ResponseEntity.ok(courses);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Add more endpoints here as needed

}
