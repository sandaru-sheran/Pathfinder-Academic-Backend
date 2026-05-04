package com.example.security.controller;

import com.example.security.model.Course;
import com.example.security.model.dto.AllocationDTO;
import com.example.security.model.dto.CourseDTO;
import com.example.security.model.dto.CourseResourceDTO;
import com.example.security.model.dto.ProgramDTO;
import com.example.security.servise.CoursesServise;
import com.example.security.servise.ProgramServise;
import com.example.security.servise.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    CoursesServise coursesServise;

    @Autowired
    ProgramServise programServise;

    @Autowired
    UserServise userServise;



    @GetMapping("/all-courses")
    public List<CourseDTO> getAllCourses() {
        return coursesServise.getAllCourses();
    }

    @GetMapping("/all-programs")
    public List<ProgramDTO> getAllPrograms() {
        return programServise.findAllPrograms();
    }

    @PostMapping("/create-course")
    public CourseDTO createCourse(@RequestBody CourseDTO courseDto) {
        return coursesServise.createCourse(courseDto);
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return coursesServise.getCourseById(id);
    }

    @PostMapping("/lecturer-allocation")
    public AllocationDTO lectureAllocation(@RequestBody AllocationDTO allocationDTO) {
        return userServise.lectureAllocation(allocationDTO);
    }

    @PostMapping("/add-resouse")
    public CourseResourceDTO addResouse(@RequestBody CourseResourceDTO courseResourceDTO){
        System.out.println(courseResourceDTO);
        return coursesServise.addResouse(courseResourceDTO);
    }

}
