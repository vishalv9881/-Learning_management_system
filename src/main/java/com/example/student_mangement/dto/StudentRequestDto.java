package com.example.student_mangement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private String username;
    private String studentName;
    private String studentGender;
    private String email;
    private String password;
}
