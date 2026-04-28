package com.example.security.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RosterDTO {
    private Long enrolmentId;
    private String registerNumber;
    private String name;
    private String grade;
}
