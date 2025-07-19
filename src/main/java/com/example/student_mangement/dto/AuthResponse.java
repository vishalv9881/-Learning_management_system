package com.example.student_mangement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String email;
    private String password;
    private String token;

    public AuthResponse(String token, String s) {

        this.token = token;
    }


}
