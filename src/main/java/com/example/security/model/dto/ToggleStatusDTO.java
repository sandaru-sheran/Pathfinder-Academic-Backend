package com.example.security.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToggleStatusDTO {
    String status;
    boolean isEnabled;
}
