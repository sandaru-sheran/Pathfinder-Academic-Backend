package com.example.security.controller;

import com.example.security.model.dto.AssignGradeDTO;
import com.example.security.model.dto.CourseResourceDTO;
import com.example.security.model.dto.LecturerCoursesDTO;
import com.example.security.model.dto.RosterDTO;
import com.example.security.servise.CoursesServise;
import com.example.security.servise.JWTService;
import com.example.security.servise.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lecturer")
public class LecturerController {

    @Autowired
    JWTService jwtService;

    @Autowired
    LecturerService lecturerService;

    @Autowired
    CoursesServise coursesServise;


    @GetMapping("/allocated-courses")
    public List<LecturerCoursesDTO> getLecturerCourses(@RequestHeader(value = "Authorization")String token) {

        token = token.substring(7);

        Long userId=jwtService.extractUserId(token);
        System.out.println(userId);

        List<LecturerCoursesDTO> lecturerCoursesDTOS = new ArrayList<>();
        lecturerCoursesDTOS.add(lecturerService.getLecturerCourses(userId));
        return lecturerCoursesDTOS;
    }

    @GetMapping("/courses/{courseId}/roster")
    public List<RosterDTO> getCourseRoster(@PathVariable Long courseId) {
        return lecturerService.getCourseRoster(courseId);
    }

    @PostMapping("/enrollments/{enrollmentId}/grade")
    public AssignGradeDTO assignGrade(@PathVariable Long enrollmentId,@RequestBody AssignGradeDTO assignGradeDTO) {
        return lecturerService.assignGrade(enrollmentId, assignGradeDTO);
    }

    @PostMapping("/add-resouse")
    public CourseResourceDTO addResouse(@RequestBody CourseResourceDTO courseResourceDTO){
        return coursesServise.addResouse(courseResourceDTO);
    }

}
