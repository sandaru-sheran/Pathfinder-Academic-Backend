package com.example.security.controller;

import com.example.security.model.CourseAllocation;
import com.example.security.model.User;
import com.example.security.model.dto.AllocationDTO;
import com.example.security.model.dto.LogInDTO;
import com.example.security.model.dto.ToggleStatusDTO;
import com.example.security.model.dto.UserDTO;

import java.util.List;

public interface UserController {

    String login(LogInDTO logInDto);

    boolean createUser(User user);

    List<UserDTO> findAllUserDtos();

    ToggleStatusDTO toggleStatus(Long id);

    AllocationDTO lectureAllocation(AllocationDTO allocationDTO);

}
