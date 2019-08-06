package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Instruction;
import com.projetb32.koulouwakel.service.CategoryService;
import com.projetb32.koulouwakel.service.IngredientSerivce;

import com.projetb32.koulouwakel.service.InstructionService;
import com.projetb32.koulouwakel.service.StepService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class InstructionController {
    private static final Logger log = LoggerFactory.getLogger(InstructionController.class);


    @Autowired
    private IngredientSerivce ingredientSerivce ;

    @Autowired
    private StepService stepService ;

    @Autowired
    private InstructionService instructionService ;


    @GetMapping("/instructions")
    public ResponseEntity<List<Instruction>> retreiveInstruction() {

        if (instructionService.getAllInstruction().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(instructionService.getAllInstruction(), HttpStatus.OK);

    }

    @GetMapping("/instructions/{instructionId}")
    public ResponseEntity<Optional<Instruction>> retreiveInstructionById(@PathVariable String instructionId) {


        if (!instructionService.getInstructionById(Long.parseLong(instructionId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(instructionService.getInstructionById(Long.parseLong(instructionId)), HttpStatus.OK);
        }
    }

    @PostMapping("/instructions/{ingredient_id}/{step_id}")
    public ResponseEntity<Instruction> addInstruction(@RequestBody Instruction instruction,@PathVariable long ingredient_id,@PathVariable long step_id) {

        //  log.info("affichage"+activite.getEvenement());
        Instruction ingredientLocal = instructionService.addInstruction(instruction,step_id,ingredient_id);

        if (ingredientLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(ingredientLocal, HttpStatus.OK);
        }
    }

    @PostMapping("/instructions/{step_id}")
    public ResponseEntity<Instruction> addInstructions(@RequestBody Instruction instruction,@PathVariable long step_id) {

        //  log.info("affichage"+activite.getEvenement());
        Instruction ingredientLocal = instructionService.addInstructions(instruction,step_id);

        if (ingredientLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(ingredientLocal, HttpStatus.OK);
        }
    }


    @DeleteMapping("/instructions/{instructionId}")
    public ResponseEntity<Instruction> deleteInstruction(@PathVariable String instructionId) {

        if (instructionService.getInstructionById(Long.parseLong(instructionId)).isPresent()) {

            instructionService.deleteInstruction(Long.parseLong(instructionId));

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }









}
