package com.example.security.servise;

import com.example.security.model.Program;

import java.util.List;

public interface ProgramServise {
    Boolean addProgram(Program program);
    Boolean deleteProgram(Long programId);
    Program findProgramById(Long id);
    Program findProgramByName(String name);
    Boolean updateProgram(Program program);
    List<Program> findAllPrograms();
}
