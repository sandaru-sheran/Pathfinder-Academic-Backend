package com.example.security.controller.impl;

import com.example.security.controller.ProgramController;
import com.example.security.model.Program;
import com.example.security.servise.ProgramServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/program")
public class ProgramControllerImpl implements ProgramController {

    @Autowired
    private ProgramServise programServise;
    public List<Program> getAllProgram() {
        return programServise.findAllPrograms();
    }
    public String addProgram(Program program) {
         programServise.addProgram(program);
         return "Program added successfully";
    }
    public String updateProgram(Program program) {
        return "Program updated";
    }
    public Boolean deleteProgram(Long id) {
        return true;
    }

}
