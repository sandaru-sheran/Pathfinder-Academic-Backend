package com.example.security.servise.impl;

import com.example.security.model.Course;
import com.example.security.model.CourseAllocation;
import com.example.security.model.Enrollment;
import com.example.security.model.dto.StudentAllCourseDTO;
import com.example.security.model.dto.StudentCourseDTO;
import com.example.security.model.dto.StudentEnrollDTO;
import com.example.security.model.dto.TranscriptDTO;
import com.example.security.repository.AllocationRepository;
import com.example.security.repository.CoursesRepository;
import com.example.security.repository.EnrolmentRepository;
import com.example.security.repository.UserReposotry;
import com.example.security.servise.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private EnrolmentRepository enrolmentRepository;

    @Autowired
    UserReposotry userReposotry;

    @Autowired
    private AllocationRepository allocationRepository;

    @Autowired
    CoursesRepository  coursesRepository;

    @Override
    public List<StudentCourseDTO> getMyCourses(Long studentId) {
        List<Enrollment> enrollments = enrolmentRepository.findByStudentId(studentId);
        List<StudentCourseDTO> studentCourseDTOS = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            CourseAllocation allocation = allocationRepository.findFirstByCourse(enrollment.getCourse());
            String firstName = (allocation != null && allocation.getLecturer() != null) ? allocation.getLecturer().getFirstName() : "not";
            String lastName = (allocation != null && allocation.getLecturer() != null) ? allocation.getLecturer().getLastName() : "allocated";

            studentCourseDTOS.add(new StudentCourseDTO(
                    enrollment.getCourse().getId(),
                    enrollment.getCourse().getCourseCode(),
                    enrollment.getCourse().getCourseName(),
                    firstName+" "+lastName));
        }
        return studentCourseDTOS;
    }

    @Override
    public List<StudentAllCourseDTO> getAllCoursesForStudent(Long studentId) {
        List<Enrollment> enrollments = enrolmentRepository.findByStudentId(studentId);
        List<Course> courses = coursesRepository.findAll();
        List<StudentAllCourseDTO> studentAllCourseDTOS = new ArrayList<>();
        for (Course course : courses) {
            boolean isEnrolled = false;
            for (Enrollment enrollment : enrollments) {
                if (enrollment.getCourse().getId().equals(course.getId())) {
                    isEnrolled = true;
                    break;
                }
            }
            studentAllCourseDTOS.add(new StudentAllCourseDTO(course.getId(),
                    course.getCourseCode(),
                    course.getCourseName(),
                    course.getProgram().getProgramName(),
                    isEnrolled
                    ));
        }
        return studentAllCourseDTOS;
    }

    @Override
    public StudentEnrollDTO enrollInCourse(Long studentId, Long courseId,String semester) {
        Enrollment enrollment ;
        if(null == enrolmentRepository.findByStudentIdAndCourseId(studentId, courseId)){
            enrollment = enrolmentRepository.save(new Enrollment(userReposotry.getById(studentId), coursesRepository.getById(courseId),semester));
        }else{
            throw new RuntimeException("Student is already enrolled in this course");
        }
        return new StudentEnrollDTO("Successfully enrolled in "+enrollment.getCourse().getCourseName(),enrollment.getId(),enrollment.getSemester());
    }

    @Override
    public List<TranscriptDTO> getTranscript(Long studentId) {
        List<Enrollment> enrollments = enrolmentRepository.findByStudentId(studentId);
        List<TranscriptDTO> transcriptDTOS = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            transcriptDTOS.add(new TranscriptDTO(enrollment.getCourse().getCourseCode(),
                    enrollment.getCourse().getCourseName(),
                    enrollment.getSemester(),
                    enrollment.getGrade()));
        }
        return transcriptDTOS;
    }
}
