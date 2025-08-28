package com.example.student_mangement.service;

import com.example.student_mangement.dto.CourseResponseDto;
import com.example.student_mangement.dto.StudentRequestDto;
import com.example.student_mangement.entity.Student;
import com.example.student_mangement.repository.StudentRepository;
import com.example.student_mangement.translator.StudentTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;
    private final StudentTranslator studentTranslator;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public StudentServiceImpl(
            StudentRepository studentRepository,
            StudentTranslator studentTranslator,
            PasswordEncoder passwordEncoder,
            RestTemplate restTemplate
    ) {
        this.studentRepository = studentRepository;
        this.studentTranslator = studentTranslator;
        this.passwordEncoder = passwordEncoder;
        this.restTemplate = restTemplate;
    }

    @Override
    public String registerStudent(StudentRequestDto studentRequestDto) {
        logger.info("=== SERVICE: Starting student registration ===");

        try {
            // Check if email already exists
            if (studentRepository.existsByEmail(studentRequestDto.getEmail())) {
                logger.warn("Email already exists: {}", studentRequestDto.getEmail());
                return "Email already registered!";
            }

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

    @Override
    public List<CourseResponseDto> getAllCourses() {
        logger.info("=== SERVICE: Calling Course microservice to fetch courses ===");

        String courseServiceUrl = "http://COURSE-MANAGEMENT-SYSTEM/api/courses";

        try {
            ResponseEntity<List<CourseResponseDto>> response = restTemplate.exchange(
                    courseServiceUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<CourseResponseDto>>() {}
            );

            return response.getBody();

        } catch (Exception e) {
            logger.error("Failed to fetch courses from Course microservice", e);
            throw new RuntimeException("Unable to fetch courses at the moment.");
        }
    }


}
