package com.example.security.repository;

import com.example.security.model.CourseResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseResouseRepository extends JpaRepository<CourseResource, Long> {
    List<CourseResource> findByCourseId(Long courseId);
}
