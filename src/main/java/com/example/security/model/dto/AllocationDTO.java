package com.example.security.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllocationDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private Long lectureId;
    private Long courseId;
    private String semester;
}
