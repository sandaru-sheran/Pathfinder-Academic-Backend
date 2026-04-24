package com.example.security.servise;

import com.example.security.model.User;

public interface JWTService {
    String generateToken(User user);
    
    String extractEmail(String token);
    
    boolean validateToken(String token);
}
