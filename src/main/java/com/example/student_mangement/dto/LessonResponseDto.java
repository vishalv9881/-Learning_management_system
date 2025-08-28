package com.example.student_mangement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponseDto {
    private Long id;
    private String title;
    private String content;
    private String duration;
    private String videoUrl;
}
