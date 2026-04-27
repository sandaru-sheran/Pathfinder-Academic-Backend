package com.example.security.controller.impl;

import com.example.security.controller.CoursesController;
import com.example.security.model.Course;
import com.example.security.model.dto.CourseDTO;
import com.example.security.servise.CoursesServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CoursesControllerImpl implements CoursesController {

    @Autowired
    CoursesServise coursesServise;

    @Override
    @GetMapping("getall")
    public List<Course> getAllCourses() {
        return coursesServise.getAllCourses();
    }

    @Override
    @GetMapping("/{id}")
    public Course getCourseById(Long id) {
        return coursesServise.getCourseById(id);
    }

    @Override
    @PostMapping("/create")
    public CourseDTO createCourse(CourseDTO courseDto) {
        return coursesServise.createCourse(courseDto);
    }

    @Override
    @PatchMapping
    public Boolean updateCourse(Course course) {
        return coursesServise.updateCourse(course);
    }

    @Override
    public Boolean deleteCourse(Long id) {
        return coursesServise.deleteCourse(id);
    }
}
