package com.example.security.servise;

import com.example.security.model.dto.StudentAllCourseDTO;
import com.example.security.model.dto.StudentCourseDTO;
import com.example.security.model.dto.StudentEnrollDTO;
import com.example.security.model.dto.TranscriptDTO;

import java.util.List;

public interface StudentService {
    List<StudentCourseDTO> getMyCourses(Long studentId);
    List<StudentAllCourseDTO> getAllCoursesForStudent(Long studentId);
    StudentEnrollDTO enrollInCourse(Long studentId, Long courseId,String semester);
    List<TranscriptDTO> getTranscript(Long studentId);
}
