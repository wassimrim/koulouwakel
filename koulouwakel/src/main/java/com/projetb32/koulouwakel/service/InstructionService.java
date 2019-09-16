package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Instruction;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.InstructionRepository;
import com.projetb32.koulouwakel.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InstructionService {
    @Autowired
    private StepRepository stepRepository;
    @Autowired
    private InstructionRepository instructionRepository;
    @Autowired
    private IngredientRepository IngredientRepository;

    public Instruction addInstruction(Instruction instruction, long step_id, long ingredient_id) {

        instruction.setIngredient(IngredientRepository.findById(ingredient_id).get());
        instruction.setStep(stepRepository.findById(step_id).get());
        return instructionRepository.save(instruction);
    }

    public Instruction addInstructions(Instruction instruction, long step_id) {
        instruction.setStep(stepRepository.findById(step_id).get());
        return instructionRepository.save(instruction);
    }


    public List<Instruction> getAllInstruction() {
        return instructionRepository.findAll();
    }

    public Optional<Instruction> getInstructionById(Long id) {
        return instructionRepository.findById(id);

    }


    public void deleteInstruction(Long id) {
        instructionRepository.deleteById(id);

    }

    public List<Instruction> getInstructionByStepId(Long id) {
        return instructionRepository.findInstructionByStep_Id(id);

    }


}
