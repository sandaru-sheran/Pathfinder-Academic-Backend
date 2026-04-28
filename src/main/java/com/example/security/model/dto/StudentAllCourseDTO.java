package com.example.security.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAllCourseDTO {
    private Long id;
    private String courseCode;
    private String courseName;
    private String programTitle;
    private Boolean isEnrolled;
}
