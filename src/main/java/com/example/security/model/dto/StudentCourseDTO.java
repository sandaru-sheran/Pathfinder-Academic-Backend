package com.example.security.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseDTO {
    private Long courseId;
    private String courseCode;
    private String courseName;
    private String lecturerName;

}
