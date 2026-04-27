package com.example.security.controller.impl;

import com.example.security.controller.UserController;
import com.example.security.model.CourseAllocation;
import com.example.security.model.User;
import com.example.security.model.dto.AllocationDTO;
import com.example.security.model.dto.LogInDTO;
import com.example.security.model.dto.ToggleStatusDTO;
import com.example.security.model.dto.UserDTO;
import com.example.security.servise.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserControllerImpl implements UserController {

    @Autowired
    UserServise userServise;

    @Override
    @PostMapping("/create")
    public boolean createUser(@RequestBody User user){
        return userServise.createUser(user);
    }

    @Override
    @GetMapping("/getall")
    public List<UserDTO> findAllUserDtos() {
        return userServise.findAllUserDtos();
    }

    @Override
    @PostMapping("/login")
    public String login(@RequestBody LogInDTO logInDto) {
        return userServise.verify(logInDto);
    }

    @Override
    @PostMapping("/{id}/toggle-status")
    public ToggleStatusDTO toggleStatus(@PathVariable Long id){
        return userServise.toggleStatus(id);
    }

    @Override
    @PostMapping("/allocation")
    public AllocationDTO lectureAllocation(AllocationDTO allocationDTO) {
        return userServise.lectureAllocation(allocationDTO);
    }


}
