package com.example.student_mangement.service;

import com.example.student_mangement.dto.UserRequestDto;
import com.example.student_mangement.dto.UserResponseDto;
import java.util.List;

public interface UserService {
    String registerUser(UserRequestDto userRequestDto);
    List<UserResponseDto> getAllUsers();
}
