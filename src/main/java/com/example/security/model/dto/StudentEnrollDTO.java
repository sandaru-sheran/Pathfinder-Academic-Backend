package com.example.security.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEnrollDTO {
    private String massage;
    private Long enrollmentId;
    private String semester;
}
