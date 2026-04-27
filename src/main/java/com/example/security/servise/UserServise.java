package com.example.security.servise;

import com.example.security.model.CourseAllocation;
import com.example.security.model.User;
import com.example.security.model.dto.AllocationDTO;
import com.example.security.model.dto.LogInDTO;
import com.example.security.model.dto.ToggleStatusDTO;
import com.example.security.model.dto.UserDTO;

import java.util.List;

public interface UserServise {

    List<UserDTO> findAllUserDtos();

    boolean createUser(User user);

    String verify(LogInDTO logInDto);

    ToggleStatusDTO toggleStatus(Long id);

    AllocationDTO lectureAllocation(AllocationDTO allocationDTO);
}
