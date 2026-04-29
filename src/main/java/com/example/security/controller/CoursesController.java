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

    @PatchMapping
    public Boolean updateCourse(@RequestBody Course course) {
        return coursesServise.updateCourse(course);
    }

    public Boolean deleteCourse(Long id) {
        return coursesServise.deleteCourse(id);
    }
}
