package com.example.student_mangement.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDto {
    private String StudentName;
    private String studentEmail;
    private String password;
}
