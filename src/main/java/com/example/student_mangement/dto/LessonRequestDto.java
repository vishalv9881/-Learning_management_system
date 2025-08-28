package com.example.student_mangement.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.temporal.TemporalUnit;

@Setter
@Getter
public class LessonRequestDto {
    private String title;
    private String content;
    private String duration;
    private String videoUrl;

}
