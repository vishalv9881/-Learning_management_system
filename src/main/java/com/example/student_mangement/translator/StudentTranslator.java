package com.example.student_mangement.translator;

import com.example.student_mangement.dto.StudentRequestDto;
import com.example.student_mangement.dto.StudentResponseDto;
import com.example.student_mangement.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class StudentTranslator {

    private static final Logger logger = LoggerFactory.getLogger(StudentTranslator.class);
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentTranslator(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Student translateToStudent(StudentRequestDto studentRequestDto) {
        logger.info("=== TRANSLATOR: Converting DTO to Entity ===");

        Student student = new Student();
        student.setUsername(studentRequestDto.getUsername()); // ✅ Added
        student.setStudentName(studentRequestDto.getStudentName());
        student.setStudentGender(studentRequestDto.getStudentGender());
        student.setEmail(studentRequestDto.getEmail());

        logger.info("Encoding password...");
        String encodedPassword = passwordEncoder.encode(studentRequestDto.getPassword());
        student.setPassword(encodedPassword);
        logger.info("Password encoded successfully");

        return student;
    }


    public StudentResponseDto translateToStudentResponseDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setStudentName(student.getStudentName());
        return studentResponseDto;
    }
}