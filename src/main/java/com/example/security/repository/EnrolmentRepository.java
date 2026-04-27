package com.example.security.repository;

import com.example.security.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrolmentRepository extends JpaRepository<Enrollment, Long> {
     List<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId);
     List<Enrollment> findByCourseId(Long courseId);
}
