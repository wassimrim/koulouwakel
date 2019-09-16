package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Recipe;
import com.projetb32.koulouwakel.service.FamilyService;
import com.projetb32.koulouwakel.service.RecipeService;
import com.projetb32.koulouwakel.service.UserPrinciple;
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
public class RecipeController {

    private static final Logger log = LoggerFactory.getLogger(RecipeController.class);


    @Autowired
    private RecipeService recipeService;


    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> retreiveRecipe() {
        List<Recipe> listRecipe = null;
        listRecipe = recipeService.getAllRecipe();
        if (listRecipe.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listRecipe, HttpStatus.OK);

    }

    @GetMapping("/recipes/recipeid/{recipeId}")
    public ResponseEntity<Optional<Recipe>> retreiveRecipeById(@PathVariable long recipeId) {
        Optional<Recipe> recipeList = null;
        recipeList = recipeService.getRecipeById(recipeId);
        if (!recipeList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(recipeList, HttpStatus.OK);

    }


    @GetMapping("/recipes/difficulty/{recipeDifficulty}")
    public ResponseEntity<List<Recipe>> retreiveRecipeByDifficulty(@PathVariable String recipeDifficulty) {

        List<Recipe> recipeList = null;
        recipeList = recipeService.findByDifficulty(recipeDifficulty);

        if (recipeList == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(recipeList, HttpStatus.OK);

    }


    @GetMapping("/recipes/recipetitle/{recipeTitle}")
    public ResponseEntity<Optional<Recipe>> retreiveRecipeByTitle(@PathVariable String recipeTitle) {

        Optional<Recipe> recipeList = null;
        recipeList = recipeService.getRecipeByTitle(recipeTitle);

        if (!recipeList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(recipeList, HttpStatus.OK);

    }

    @PostMapping("/recipes/{family_id}/{user_id}")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe, @PathVariable long family_id, @PathVariable long user_id) {

        Recipe recipeLocal = recipeService.addRecipe(recipe, family_id, user_id);

        if (recipeLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(recipeLocal, HttpStatus.OK);

    }


    @DeleteMapping("/recipes/{recipeId}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable long recipeId) {
        recipeService.deleteRecipe(recipeId);
        return ResponseEntity.accepted().build();


    }


}
