package com.example.security.controller;

import com.example.security.model.Course;
import com.example.security.model.dto.CourseDTO;
import com.example.security.servise.CoursesServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CoursesController {

    @Autowired
    CoursesServise coursesServise;

    @GetMapping("getall")
    public List<Course> getAllCourses() {
        return coursesServise.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return coursesServise.getCourseById(id);
    }

    @PostMapping("/create")
    public CourseDTO createCourse(@RequestBody CourseDTO courseDto) {
        return coursesServise.createCourse(courseDto);
    }

    @PatchMapping
    public Boolean updateCourse(@RequestBody Course course) {
        return coursesServise.updateCourse(course);
    }

    public Boolean deleteCourse(Long id) {
        return coursesServise.deleteCourse(id);
    }
}
