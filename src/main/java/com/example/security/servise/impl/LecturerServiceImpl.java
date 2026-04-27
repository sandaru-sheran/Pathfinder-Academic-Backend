package com.example.security.servise.impl;

import com.example.security.model.CourseAllocation;
import com.example.security.model.Enrollment;
import com.example.security.model.User;
import com.example.security.model.dto.LecturerCoursesDTO;
import com.example.security.repository.AllocationRepository;
import com.example.security.repository.EnrolmentRepository;
import com.example.security.repository.UserReposotry;
import com.example.security.servise.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    AllocationRepository allocationRepository;

    @Autowired
    UserReposotry userReposotry;

    @Autowired
    EnrolmentRepository enrolmentRepository;

    @Override
    public LecturerCoursesDTO getLecturerCourses(Long Id) {
        User user = userReposotry.findById(Id).orElseThrow();
        CourseAllocation courseAllocation=allocationRepository.getByLecturer(user);
        List<Enrollment> enrollments = enrolmentRepository.findByStudentIdAndCourseId(user.getId(), courseAllocation.getCourse().getId());


        return new LecturerCoursesDTO(courseAllocation.getCourse().getId(),
                courseAllocation.getCourse().getCourseCode(),
                courseAllocation.getCourse().getCourseName(),
                courseAllocation.getSemester(),
                enrollments.size());
    }
}
