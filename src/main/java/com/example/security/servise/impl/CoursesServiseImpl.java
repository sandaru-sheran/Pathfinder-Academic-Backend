package com.example.security.servise.impl;

import com.example.security.model.Course;
import com.example.security.model.CourseResource;
import com.example.security.model.Program;
import com.example.security.model.dto.CourseDTO;
import com.example.security.model.dto.CourseResourceDTO;
import com.example.security.repository.CourseResouseRepository;
import com.example.security.repository.CoursesRepository;
import com.example.security.repository.ProgramRepository;
import com.example.security.servise.CoursesServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CoursesServiseImpl implements CoursesServise {
    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private CourseResouseRepository courseResouseRepository;

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = coursesRepository.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();

        for (Course course : courses) {
            courseDTOList.add(new CourseDTO(course.getId(), course.getCourseName(), course.getCourseCode(), course.getCredits(), course.getProgram().getId()));
        }
        return courseDTOList;
    }

    @Override
    public Course getCourseById(Long id) {
        return coursesRepository.getOne(id);
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDto) {
        Course course = new Course();
        course.setCourseName(courseDto.getName());
        course.setCourseCode(courseDto.getCode());
        course.setCredits(courseDto.getCredits());
        Program program = new Program();
        program =  programRepository.findById(courseDto.getProgramId()).orElseThrow(() -> new RuntimeException("Program not found with id: " + courseDto.getProgramId()));
        course.setProgram(program);
        course = coursesRepository.save(course);
        return new CourseDTO(course.getId(), course.getCourseName(), course.getCourseCode(), course.getCredits(), course.getProgram().getId());
    }

    @Override
    public Boolean updateCourse(Course course) {
        return coursesRepository.save(course).getId() != null;
    }

    @Override
    public Boolean deleteCourse(Long id) {
        if (!coursesRepository.existsById(id)) return false;

        coursesRepository.deleteById(id);
        return true;

    }

    @Override
    public CourseResourceDTO addResouse(CourseResourceDTO courseResourceDTO) {

        courseResourceDTO = youtubeCheck(courseResourceDTO);

        Course course = coursesRepository.findById(courseResourceDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));


        CourseResource courseResource = courseResouseRepository.save(new CourseResource(courseResourceDTO.getTitle(), courseResourceDTO.getVideoId(), course));
        return new CourseResourceDTO(courseResource.getId(),courseResource.getCourse().getId() ,courseResource.getTitle(), courseResource.getVideoId());
    }

    private CourseResourceDTO youtubeCheck(CourseResourceDTO courseResourceDTO) {
        String youtubeUrl = "https://www.youtube.com/watch?v=" + courseResourceDTO.getVideoId();
        String oembedUrl = "https://www.youtube.com/oembed?url=" + youtubeUrl + "&format=json";

        RestTemplate restTemplate = new RestTemplate();

        if(courseResourceDTO.getTitle() == null || courseResourceDTO.getTitle().trim().isEmpty()){
            try {
                @SuppressWarnings("unchecked")
                Map<String, Object> response = restTemplate.getForObject(oembedUrl, Map.class);

                if (response != null && response.containsKey("title")) {
                    courseResourceDTO.setTitle(String.valueOf(response.get("title")));
                }
            } catch (Exception e) {
                System.err.println("Failed to fetch YouTube title for ID: " + courseResourceDTO.getVideoId());
                throw new IllegalArgumentException("Invalid YouTube link. The video was not found or is private.");
            }
        }else{
            try {
                @SuppressWarnings("unchecked")
                Map<String, Object> response = restTemplate.getForObject(oembedUrl, Map.class);
            } catch (Exception e) {
                System.err.println("Failed to fetch YouTube title for ID: " + courseResourceDTO.getVideoId());
                throw new IllegalArgumentException("Invalid YouTube link. The video was not found or is private.");
            }
        }
        return courseResourceDTO;
    }
}
