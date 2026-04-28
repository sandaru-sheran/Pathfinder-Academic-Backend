package com.example.security.controller;

import com.example.security.model.dto.StudentAllCourseDTO;
import com.example.security.model.dto.StudentCourseDTO;
import com.example.security.model.dto.StudentEnrollDTO;
import com.example.security.model.dto.TranscriptDTO;
import com.example.security.servise.JWTService;
import com.example.security.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService  studentService;

    @Autowired
    JWTService  jwtService;

    @GetMapping("/my-courses")
    public List<StudentCourseDTO> getMyCourses(@RequestHeader(value = "Authorization")String token) {
        token = token.substring(7);
        return studentService.getMyCourses(jwtService. extractUserId(token));
    }

    @GetMapping("/catalog")
    public List<StudentAllCourseDTO> getCatalog(@RequestHeader(value = "Authorization")String token) {
        token = token.substring(7);
        return studentService.getAllCoursesForStudent(jwtService. extractUserId(token));

    }

    @PostMapping("/enroll/{courseId}")
    public StudentEnrollDTO enrollInCourse(@RequestHeader(value = "Authorization")String token, @PathVariable Long courseId, @RequestBody String semester) {
        token = token.substring(7);
        Long studentId = jwtService.extractUserId(token);
        return studentService.enrollInCourse(studentId, courseId,semester);
    }

    @GetMapping("/transcript")
    public List<TranscriptDTO> getTranscript(@RequestHeader(value = "Authorization")String token) {
        token = token.substring(7);
        return studentService.getTranscript(jwtService. extractUserId(token));
    }
}
