package com.example.security.servise.impl;

import com.example.security.model.User;
import com.example.security.servise.JWTService;
import com.example.security.util.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@Service
public class JWTServiceImpl implements JWTService {

    @Value("${jwt.secret:mySecretKeyForJWTTokenGenerationWithMinimum256BitsLength1234567890}")
    private String secretKey;

    @Value("${jwt.expiration:86400000}")
    private long expirationTime;

    @Override
    public String generateToken(User user) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        Instant now = Instant.now();
        Instant expiryDate = now.plusMillis(expirationTime);
        System.out.println("DEBUG - Generating token for: " + user.getEmail() + " | Role is: " + user.getRole());
        return Jwts.builder()
                .subject(user.getEmail())
                .claim("userId", user.getId())
                .claim("role", user.getRole())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .claim("registrationNumber", user.getRegistrationNumber())
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiryDate))
                .signWith(key)
                .compact();
    }

    @Override
    public String extractEmail(String token) {
        try {
            Claims claims = getAllClaimsFromToken(token);
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Long extractUserId(String token) {
        try {
            Claims claims = getAllClaimsFromToken(token);
            Long userId = claims.get("userId", Long.class);
            return userId;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public boolean validateToken(String token) {
        try {
            getAllClaimsFromToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getAllClaimsFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
