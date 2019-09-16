package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.RecipeIngredient;
import com.projetb32.koulouwakel.service.IngredientSerivce;
import com.projetb32.koulouwakel.service.RecipeIngredientService;
import com.projetb32.koulouwakel.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class RecipeIngredientController {

    private static final Logger log = LoggerFactory.getLogger(RecipeIngredientController.class);

    @Autowired
    private RecipeIngredientService recipeIngredientService;


    @GetMapping("/recipeIngredients")
    public ResponseEntity<List<RecipeIngredient>> retreiveRecipeIngredient() {

        List<RecipeIngredient> recipeIngredientList = null;
        recipeIngredientList = recipeIngredientService.getAllRecipeIngredient();

        if (recipeIngredientList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(recipeIngredientList, HttpStatus.OK);

    }


    @PostMapping("/recipeIngredients/{recipeId}/{ingredientId}")
    public ResponseEntity<RecipeIngredient> addRecipeIngredient(@PathVariable long recipeId, @PathVariable long ingredientId) {


        RecipeIngredient ingredientLocal = recipeIngredientService.addRecipeIngredient(recipeId, ingredientId);

        if (ingredientLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(ingredientLocal, HttpStatus.OK);

    }


    @DeleteMapping("/recipeIngredients/{recipeId}/{ingredientId}")
    public ResponseEntity<RecipeIngredient> deleteRecipeIngredient(@PathVariable long recipeId, @PathVariable long ingredientId) {

        recipeIngredientService.deleteRecipeIngredient(recipeId, ingredientId);
        return ResponseEntity.accepted().build();


    }


}
