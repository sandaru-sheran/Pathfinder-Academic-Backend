package com.example.security.servise;

import com.example.security.model.dto.AssignGradeDTO;
import com.example.security.model.dto.LecturerCoursesDTO;
import com.example.security.model.dto.RosterDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface LecturerService {
    LecturerCoursesDTO getLecturerCourses(Long id);

    List<RosterDTO> getCourseRoster(Long courseId);

    AssignGradeDTO assignGrade(Long enrollmentId, AssignGradeDTO assignGradeDTO);
}
