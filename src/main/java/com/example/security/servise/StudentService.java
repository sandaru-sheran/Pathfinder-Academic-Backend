package com.example.security.servise;

import com.example.security.model.dto.*;

import java.util.List;

public interface StudentService {
    List<StudentCourseDTO> getMyCourses(Long studentId);
    List<StudentAllCourseDTO> getAllCoursesForStudent(Long studentId);
    StudentEnrollDTO enrollInCourse(Long studentId, Long courseId,String semester);
    List<TranscriptDTO> getTranscript(Long studentId);
    List<CourseResourceDTO> getResouse(Long courseId, Long aLong);
}
