package com.example.security.servise.impl;

import com.example.security.model.Course;
import com.example.security.model.Program;
import com.example.security.model.dto.CourseDTO;
import com.example.security.repository.CoursesRepository;
import com.example.security.repository.ProgramRepository;
import com.example.security.servise.CoursesServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesServiseImpl implements CoursesServise {
    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = coursesRepository.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();

        for (Course course : courses) {
            courseDTOList.add(new CourseDTO(course.getId(), course.getCourseName(), course.getCourseCode(), course.getCredits(), course.getProgram().getId()));
        }
        return courseDTOList;
    }

    @Override
    public Course getCourseById(Long id) {
        return coursesRepository.getOne(id);
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDto) {
        Course course = new Course();
        course.setCourseName(courseDto.getName());
        course.setCourseCode(courseDto.getCode());
        course.setCredits(courseDto.getCredits());
        Program program = new Program();
        program =  programRepository.findById(courseDto.getProgramId()).orElseThrow(() -> new RuntimeException("Program not found with id: " + courseDto.getProgramId()));
        course.setProgram(program);
        course = coursesRepository.save(course);
        return new CourseDTO(course.getId(), course.getCourseName(), course.getCourseCode(), course.getCredits(), course.getProgram().getId());
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
