package com.example.student_mangement.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentRequestDto {
    private String username;
    private String studentName;
    private String studentGender;
    private String email;
    private String password;
}