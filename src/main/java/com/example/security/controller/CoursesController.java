package com.example.security.controller;

import com.example.security.model.Course;
import com.example.security.model.dto.CourseDTO;

import java.util.List;

public interface CoursesController{
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    CourseDTO createCourse(CourseDTO courseDto);
    Boolean updateCourse(Course course);
    Boolean deleteCourse(Long id);
}
