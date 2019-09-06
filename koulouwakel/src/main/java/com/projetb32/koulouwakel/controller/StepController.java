package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Step;
import com.projetb32.koulouwakel.service.RecipeService;
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
public class StepController {

    private static final Logger log = LoggerFactory.getLogger(IngredientController.class);


    @Autowired
    private StepService stepService ;

    @Autowired
    private RecipeService recipeService ;


    @GetMapping("/step")
    public ResponseEntity<List<Step>> retreiveStep() {

        if (stepService.getAllStep().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(stepService.getAllStep(), HttpStatus.OK);

    }

    @GetMapping("/Step/stepid/{stepId}")
    public ResponseEntity<Optional<Step>> retreiveStepById(@PathVariable String stepId) {


        if (!stepService.getStepById(Long.parseLong(stepId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(stepService.getStepById(Long.parseLong(stepId)), HttpStatus.OK);
        }
    }



    @GetMapping("/Step/recipeid/{recipeId}")
    public ResponseEntity<Optional<List<Step>>> retreiveStepByRecipeId(@PathVariable String recipeId) {


        if (!stepService.getStepByRecipeId(Long.parseLong(recipeId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(stepService.getStepByRecipeId(Long.parseLong(recipeId)), HttpStatus.OK);
        }
    }



    @PostMapping("/step/{recipeId}")
    public ResponseEntity<Step> addStep(@RequestBody Step step, @PathVariable long recipeId  ) {


        Step stepLocal = stepService.addStep(step,recipeId);

        if (stepLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(stepLocal, HttpStatus.OK);
        }
    }


    @DeleteMapping("/step/{stepId}")
    public ResponseEntity<Step> deleteStep(@PathVariable String stepId) {

        if (stepService.getStepById(Long.parseLong(stepId)).isPresent()) {

            stepService.deleteStep(Long.parseLong(stepId));

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
