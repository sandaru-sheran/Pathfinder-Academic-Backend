package com.example.security.controller.impl;

import com.example.security.controller.LecturerController;
import com.example.security.model.dto.LecturerCoursesDTO;
import com.example.security.servise.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lecturer")
public class LecturerControllerImpl implements LecturerController {

    @Autowired
    JWTService jwtService;

    @Override
    @GetMapping("allocated-courses")
    public LecturerCoursesDTO getLecturerCourses(@RequestHeader(value = "Authorization")String token) {

        Long userId=jwtService.extractUserId(token);

        return null;
    }
}
