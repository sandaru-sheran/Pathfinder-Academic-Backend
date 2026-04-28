package com.example.security.repository;

import com.example.security.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrollment, Long> {
     Enrollment findByStudentIdAndCourseId(Long studentId, Long courseId);
     List<Enrollment> findByCourseId(Long courseId);
     List<Enrollment> findByStudentId(Long studentId);
}
