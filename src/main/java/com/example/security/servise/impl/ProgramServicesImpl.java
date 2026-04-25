package com.example.security.servise.impl;

import com.example.security.model.Program;
import com.example.security.repository.ProgramRepository;
import com.example.security.servise.ProgramServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServicesImpl implements ProgramServise {

    @Autowired
    private ProgramRepository programRepository;

    @Override
    public Boolean addProgram(Program program) {
        return programRepository.save(program) != null;
    }

    @Override
    public Boolean deleteProgram(Long programId) {
        if(programRepository.existsById(programId)){
            programRepository.deleteById(programId);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Program findProgramById(Long id) {
        return programRepository.findById(id).orElse(null);
    }

    @Override
    public Program findProgramByName(String name) {
        return programRepository.findByProgramName(name);
    }

    @Override
    public Boolean updateProgram(Program program) {
        return programRepository.save(program) != null;
    }

    @Override
    public List<Program> findAllPrograms() {
        return programRepository.findAll();
    }
}
