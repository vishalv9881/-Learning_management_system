package com.example.student_mangement.service;

import com.example.student_mangement.dto.CourseRequestDto;
import com.example.student_mangement.dto.CourseResponseDto;
import com.example.student_mangement.dto.StudentRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    String registerStudent(StudentRequestDto studentRequestDto);

    List<CourseResponseDto> getAllCourses();



}
