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
    private StepService stepService;

    ;

    @GetMapping("/step")
    public ResponseEntity<List<Step>> retreiveStep() {

        List<Step> stepList = null;
        stepList = stepService.getAllStep();
        if (stepList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(stepList, HttpStatus.OK);

    }

    @GetMapping("/step/stepid/{stepId}")
    public ResponseEntity<Optional<Step>> retreiveStepById(@PathVariable long stepId) {

        Optional<Step> stepList = null;

        stepList = stepService.getStepById(stepId);
        if (!stepList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(stepList, HttpStatus.OK);

    }


    @GetMapping("/step/recipeid/{recipeId}")
    public ResponseEntity<List<Step>> retreiveStepByRecipeId(@PathVariable long recipeId) {

        List<Step> stepList = null;
        stepList = stepService.getStepByRecipeId(recipeId);
        if (stepList == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(stepList, HttpStatus.OK);
    }


    @PostMapping("/step/{recipeId}")
    public ResponseEntity<Step> addStep(@RequestBody Step step, @PathVariable long recipeId) {


        Step stepLocal = stepService.addStep(step, recipeId);

        if (stepLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(stepLocal, HttpStatus.OK);

    }


    @DeleteMapping("/step/{stepId}")
    public ResponseEntity<Step> deleteStep(@PathVariable long stepId) {
        stepService.deleteStep(stepId);
        return ResponseEntity.accepted().build();


    }

}
