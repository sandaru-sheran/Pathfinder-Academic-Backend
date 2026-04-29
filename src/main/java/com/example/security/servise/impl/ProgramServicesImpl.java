package com.example.security.servise.impl;

import com.example.security.model.Program;
import com.example.security.model.dto.ProgramDTO;
import com.example.security.repository.ProgramRepository;
import com.example.security.servise.ProgramServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramServicesImpl implements ProgramServise {

    @Autowired
    private ProgramRepository programRepository;

    @Override
    public ProgramDTO addProgram(ProgramDTO programDto) {

        Program program1 = new Program();
        program1.setProgramName(programDto.getTitle());
        program1.setProgramCode(programDto.getCode());
        program1 = programRepository.save(program1);
        return new ProgramDTO(program1.getId(), program1.getProgramName(), program1.getProgramCode());
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
    public List<ProgramDTO> findAllPrograms() {
        List<Program> programs = programRepository.findAll();
        List<ProgramDTO> programDTOList = new ArrayList<>();

        for (Program program : programs) {
            programDTOList.add(new ProgramDTO(program.getId(), program.getProgramName(), program.getProgramCode()));
        }
        return programDTOList;
    }
}
