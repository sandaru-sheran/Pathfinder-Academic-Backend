package com.example.security.controller.impl;

import com.example.security.controller.ProgramController;
import com.example.security.model.Program;
import com.example.security.model.dto.ProgramDTO;
import com.example.security.servise.ProgramServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/program")
public class ProgramControllerImpl implements ProgramController {

    @Autowired
    private ProgramServise programServise;

    @GetMapping("/getall")
    public List<Program> getAllProgram() {
        return programServise.findAllPrograms();
    }

    @PostMapping("/add")
    public ProgramDTO addProgram(ProgramDTO programDto) {
         return programServise.addProgram(programDto);

    }

    @PatchMapping
    public String updateProgram(Program program) {
        return "Program updated";
    }

    @DeleteMapping
    public Boolean deleteProgram(Long id) {
        return true;
    }

}
