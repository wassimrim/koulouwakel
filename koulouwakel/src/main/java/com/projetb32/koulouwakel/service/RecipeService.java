package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Recipe;
import com.projetb32.koulouwakel.repository.FamilyRepository;
import com.projetb32.koulouwakel.repository.RecipeRepository;
import com.projetb32.koulouwakel.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component

public class RecipeService {


    private final UserRepository userRepository;

    private final RecipeRepository recipeRepository;

    private final FamilyRepository familyRepository;

    public RecipeService(UserRepository userRepository, RecipeRepository recipeRepository, FamilyRepository familyRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.familyRepository = familyRepository;
    }


    public Recipe addRecipe(Recipe recipe, long family_id , long user_id) {

        recipe.setFamily(familyRepository.findById(family_id).get());
        recipe.setUser(userRepository.findById(user_id).get());

        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipe() {


        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Long id) {

        return recipeRepository.findById(id);

    }

    public Optional<Recipe> getRecipeByTitle(String title) {

        return recipeRepository.findByTitle(title);
    }


    public Optional<Recipe> getRecipeByDifficulty(String difficulty) {

        return recipeRepository.findByDifficulty(difficulty);
    }

    public void deleteRecipe(Long id) {

        recipeRepository.deleteById(id);

    }

}

