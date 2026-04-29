package com.example.security.repository;

import com.example.security.model.Course;
import com.example.security.model.CourseAllocation;
import com.example.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<CourseAllocation, Long> {
    CourseAllocation getByLecturer(User user);
    CourseAllocation findFirstByCourse(Course course);
}
