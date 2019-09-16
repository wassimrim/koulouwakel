package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Recipe;
import com.projetb32.koulouwakel.repository.FamilyRepository;
import com.projetb32.koulouwakel.repository.RecipeRepository;
import com.projetb32.koulouwakel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component

public class RecipeService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private FamilyRepository familyRepository;

    public Recipe addRecipe(Recipe recipe, long family_id, long user_id) {

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


    public void deleteRecipe(Long id) {

        recipeRepository.deleteById(id);

    }

    public List<Recipe> findByDifficulty(String difficulty) {
        return recipeRepository.findByDifficulty(difficulty).get();
    }

}

