package com.example.security.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranscriptDTO {
    private String courseCode;
    private String courseName;
    private String semester;
    private String grade;
}
