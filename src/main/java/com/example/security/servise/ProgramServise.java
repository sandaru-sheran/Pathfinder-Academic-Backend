package com.example.security.servise;

import com.example.security.model.Program;
import com.example.security.model.dto.CourseResourceDTO;
import com.example.security.model.dto.ProgramDTO;

import java.util.List;

public interface ProgramServise {
    ProgramDTO addProgram(ProgramDTO programDto);
    Boolean deleteProgram(Long programId);
    Program findProgramById(Long id);
    Program findProgramByName(String name);
    Boolean updateProgram(Program program);
    List<ProgramDTO> findAllPrograms();
}
