package com.example.security.servise;

import com.example.security.model.dto.LecturerCoursesDTO;

public interface LecturerService {
    LecturerCoursesDTO getLecturerCourses(Long id);
}
