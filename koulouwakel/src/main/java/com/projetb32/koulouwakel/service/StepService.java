package com.projetb32.koulouwakel.service;




 import com.projetb32.koulouwakel.entity.Step;
 import com.projetb32.koulouwakel.repository.RecipeRepository;
import com.projetb32.koulouwakel.repository.StepRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class StepService {



    private final RecipeRepository recipeRepository;

    private final StepRepository stepRepository;

    public StepService(RecipeRepository recipeRepository, StepRepository stepRepository) {
        this.recipeRepository = recipeRepository;
        this.stepRepository = stepRepository;
    }


    public Step addStep(Step step, long recipe_id) {

        step.setRecipe(recipeRepository.findById(recipe_id).get());


        return stepRepository.save(step);
    }

    public List<Step> getAllStep() {


        return stepRepository.findAll();
    }

    public Optional<Step> getStepById(Long id) {

        return stepRepository.findById(id);

    }

    public Optional<Step> getStepByRecipeId(Long recipe_id) {

        return stepRepository.findByRecipe_Id(recipe_id);
    }

    public void deleteStep(Long id) {

        stepRepository.deleteById(id);

    }



}
