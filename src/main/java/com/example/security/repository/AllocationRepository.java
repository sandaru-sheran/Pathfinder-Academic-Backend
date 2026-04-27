package com.example.security.repository;

import com.example.security.model.CourseAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<CourseAllocation, Long> {
}
