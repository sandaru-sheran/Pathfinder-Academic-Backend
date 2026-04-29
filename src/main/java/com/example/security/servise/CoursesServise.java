package com.example.security.servise;

import com.example.security.model.Course;
import com.example.security.model.dto.CourseDTO;

import java.util.List;

public interface CoursesServise {
    List<CourseDTO> getAllCourses();
    Course getCourseById(Long id);
    CourseDTO createCourse(CourseDTO courseDto);
    Boolean updateCourse(Course course);
    Boolean deleteCourse(Long id);
}
