package com.example.security.model.dto;

import com.example.security.util.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    Long id;
    String firstName;
    String lastName;
    String email;
    String registrationNumber;
    UserRole role;
    boolean isEnabled;
}
