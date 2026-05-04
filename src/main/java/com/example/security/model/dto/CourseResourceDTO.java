package com.example.security.model.dto;

import com.example.security.model.Course;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResourceDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private Long courseId;
    private String title;
    private String videoId;
}
