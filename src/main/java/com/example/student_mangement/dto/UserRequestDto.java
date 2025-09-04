package com.example.student_mangement.dto;

import com.example.student_mangement.enums.Role;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserRequestDto {
    private String fullName;
    private String email;
    private String password;
    private Role role;  // STUDENT / EDUCATOR
}
