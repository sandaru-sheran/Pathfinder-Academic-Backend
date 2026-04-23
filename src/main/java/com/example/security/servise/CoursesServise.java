package com.example.security.servise;

import com.example.security.model.Course;

import java.util.List;

public interface CoursesServise {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Boolean createCourse(Course course);
    Boolean updateCourse(Course course);
    Boolean deleteCourse(Long id);
}
