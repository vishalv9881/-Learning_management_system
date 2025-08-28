package com.example.student_mangement.dto;


import com.example.student_mangement.entity.Instructor;
import com.example.student_mangement.entity.InstructorContactDetails;
import com.example.student_mangement.entity.Lesson;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDto {
    private String name;
    private String description;
    private Instructor instructor;
    private String duration;
    private Lesson lesson;
    private Double coursePrice;

    private InstructorContactDetails instructorContactDetails;

}
