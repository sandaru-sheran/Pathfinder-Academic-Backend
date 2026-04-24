package com.example.security.controller.impl;

import com.example.security.controller.CoursesController;
import com.example.security.model.Course;
import com.example.security.servise.CoursesServise;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoursesControllerImpl implements CoursesController {

    @Autowired
    CoursesServise coursesServise;

    @Override
    public List<Course> getAllCourses() {
        return coursesServise.getAllCourses();
    }

    @Override
    public Course getCourseById(Long id) {
        return coursesServise.getCourseById(id);
    }

    @Override
    public Boolean createCourse(Course course) {
        return coursesServise.createCourse(course);
    }

    @Override
    public Boolean updateCourse(Course course) {
        return coursesServise.updateCourse(course);
    }

    @Override
    public Boolean deleteCourse(Long id) {
        return coursesServise.deleteCourse(id);
    }
}
