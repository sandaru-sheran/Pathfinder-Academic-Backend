package com.example.security.model;

import com.example.security.util.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String password;
    private String email;
    private UserRole role;
    private String registrationNumber;
    private String firstName;
    private String lastName;
    private Boolean isEnabled=true;

}
