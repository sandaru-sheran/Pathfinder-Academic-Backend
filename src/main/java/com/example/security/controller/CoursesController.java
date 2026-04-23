package com.example.security.controller;

import com.example.security.model.Course;

import java.util.List;

public interface CoursesController{
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Boolean createCourse(Course course);
    Boolean updateCourse(Course course);
    Boolean deleteCourse(Long id);
}
