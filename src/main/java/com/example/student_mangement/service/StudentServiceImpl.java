package com.example.student_mangement.service;

import com.example.student_mangement.dto.StudentRequestDto;
import com.example.student_mangement.entity.Student;
import com.example.student_mangement.repository.StudentRepository;
import com.example.student_mangement.translator.StudentTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;
    private final StudentTranslator studentTranslator;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentServiceImpl(
            StudentRepository studentRepository,
            StudentTranslator studentTranslator,
            PasswordEncoder passwordEncoder
    ) {
        this.studentRepository = studentRepository;
        this.studentTranslator = studentTranslator;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String registerStudent(StudentRequestDto studentRequestDto) {
        logger.info("=== SERVICE: Starting student registration ===");

        try {
            // Translate DTO to Entity
            logger.info("Translating DTO to Entity...");
            Student student = studentTranslator.translateToStudent(studentRequestDto);
            logger.info("Student entity created with email: {}", student.getEmail());

            // Save to database
            logger.info("Attempting to save student to database...");
            Student savedStudent = studentRepository.save(student);
            logger.info("Student saved successfully with ID: {}", savedStudent.getId());

            return "Registration successful!";

        } catch (Exception e) {
            logger.error("Error during registration: ", e);
            throw new RuntimeException("Registration failed", e);
        }
    }
}