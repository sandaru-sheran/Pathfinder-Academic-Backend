package com.example.security.servise.impl;

import com.example.security.model.CourseAllocation;
import com.example.security.model.User;
import com.example.security.model.dto.AllocationDTO;
import com.example.security.model.dto.LogInDTO;
import com.example.security.model.dto.ToggleStatusDTO;
import com.example.security.model.dto.UserDTO;
import com.example.security.repository.AllocationRepository;
import com.example.security.repository.CoursesRepository;
import com.example.security.repository.UserReposotry;
import com.example.security.servise.JWTService;
import com.example.security.servise.UserServise;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiseImpl implements UserServise {

    @Autowired
    UserReposotry userReposotry;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    @Autowired
    AllocationRepository allocationRepository;

    @Autowired
    CoursesRepository coursesRepository;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Override
    public List<UserDTO> findAllUserDtos() {
        return userReposotry.findAllUserDtos();
    }

    @Override
    public boolean createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        User user1 = userReposotry.save(user);
        if(user1.getId() != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String verify(LogInDTO logInDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logInDto.getUsername(), logInDto.getPassword()));
        if(authentication.isAuthenticated()){

            User authenticatedUser = userReposotry.findByEmail(logInDto.getUsername());
            return jwtService.generateToken(authenticatedUser);
        }else {
            return "User is not authenticated";
        }
    }

    @Override
    public ToggleStatusDTO toggleStatus(Long id) {
        User user = userReposotry.findById(id).orElse(null);
        if (user == null) {
            ToggleStatusDTO toggleStatusDto = new ToggleStatusDTO();
            toggleStatusDto.setStatus("User not found");
            return toggleStatusDto;
        }
        user.setIsEnabled(!user.getIsEnabled());
        userReposotry.save(user);
        ToggleStatusDTO toggleStatusDto = new ToggleStatusDTO("User status updated successfully", user.getIsEnabled());
        return toggleStatusDto;
    }

    @Override
    public AllocationDTO lectureAllocation(AllocationDTO allocationDTO) {
        CourseAllocation courseAllocation = new CourseAllocation();
        courseAllocation.setLecturer(userReposotry.findById(allocationDTO.getLectureId()).orElseThrow(() -> new RuntimeException("Lecturer not found")));
        courseAllocation.setCourse(coursesRepository.findById(allocationDTO.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found")));
        courseAllocation.setSemester(allocationDTO.getSemester());
        courseAllocation = allocationRepository.save(courseAllocation);
        allocationDTO.setId(courseAllocation.getId());
        return allocationDTO;

    }
}
