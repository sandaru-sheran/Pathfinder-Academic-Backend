package com.example.security.servise.impl;

import com.example.security.model.Course;
import com.example.security.repository.CoursesRepository;
import com.example.security.servise.CoursesServise;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoursesServiseImpl implements CoursesServise {
    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return coursesRepository.getOne(id);
    }

    @Override
    public Boolean createCourse(Course course) {
        return coursesRepository.save(course).getId() != null;
    }

    @Override
    public Boolean updateCourse(Course course) {
        return coursesRepository.save(course).getId() != null;
    }

    @Override
    public Boolean deleteCourse(Long id) {
        if (!coursesRepository.existsById(id)) return false;

        coursesRepository.deleteById(id);
        return true;

    }
}
