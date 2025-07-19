package com.example.student_mangement.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Data
public class AuthRequest {
    private String email;
    private String password;
}


