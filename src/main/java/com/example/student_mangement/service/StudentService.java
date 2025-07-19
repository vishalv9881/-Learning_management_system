package com.example.student_mangement.service;

import com.example.student_mangement.dto.StudentRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    String registerStudent(StudentRequestDto studentRequestDto);
}
