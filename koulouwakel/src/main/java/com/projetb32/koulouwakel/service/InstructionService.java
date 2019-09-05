package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Instruction;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.InstructionRepository;
import com.projetb32.koulouwakel.repository.StepRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InstructionService {

    private final StepRepository stepRepository;

    private final InstructionRepository instructionRepository;

    private final IngredientRepository IngredientRepository;

    public InstructionService(StepRepository stepRepository, InstructionRepository instructionRepository, com.projetb32.koulouwakel.repository.IngredientRepository ingredientRepository) {
        this.stepRepository = stepRepository;
        this.instructionRepository = instructionRepository;
        IngredientRepository = ingredientRepository;
    }


    public Instruction addInstruction(Instruction instruction, long ingredient_id , long step_id) {

        instruction.setIngredient(IngredientRepository.findById(ingredient_id).get());
        instruction.setStep(stepRepository.findById(step_id).get());

        return instructionRepository.save(instruction);
    }

    public Instruction addInstructions(Instruction instruction , long step_id) {


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


}
