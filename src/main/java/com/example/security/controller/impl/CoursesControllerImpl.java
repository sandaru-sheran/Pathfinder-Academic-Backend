package com.example.security.controller.impl;

import com.example.security.controller.CoursesController;
import com.example.security.model.Course;
import org.springframework.beans.factory.annotation.Autowired;

public class CoursesControllerImpl implements CoursesController {

    @Autowired
    CoursesServise coursesServise;

    @Override
    public CoursesServise getAllCourses() {
        return coursesServise;
    }

    @Override
    public Course getCourseById(Long id) {
        return null;
    }

    @Override
    public Boolean createCourse(Course course) {
        return null;
    }

    @Override
    public Boolean updateCourse(Course course) {
        return null;
    }

    @Override
    public Boolean deleteCourse(Long id) {
        return null;
    }
}
