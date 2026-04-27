package com.example.security.controller;

import com.example.security.model.dto.LecturerCoursesDTO;

public interface LecturerController {

    LecturerCoursesDTO getLecturerCourses(String token);
}
