package com.example.security.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignGradeDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String massage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long enrollmentId;
    private String grade;

}
