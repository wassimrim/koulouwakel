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
    private IngredientSerivce ingredientSerivce ;

    @Autowired
    private RecipeIngredientService recipeIngredientService ;

    @Autowired
    private RecipeService recipeService ;


    @GetMapping("/recipeIngredients")
    public ResponseEntity<List<RecipeIngredient>> retreiveRecipeIngredient() {

        if (recipeIngredientService.getAllRecipeIngredient().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(recipeIngredientService.getAllRecipeIngredient(), HttpStatus.OK);

    }



    @PostMapping("/recipeIngredients/{recipeId}/{ingredientId}")
    public ResponseEntity<RecipeIngredient> addIngredient(@RequestBody RecipeIngredient recipeIngredient, @PathVariable long recipeId, @PathVariable long ingredientId) {


        RecipeIngredient ingredientLocal = recipeIngredientService.addRecipeIngredient(recipeIngredient,recipeId,ingredientId);

        if (ingredientLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(ingredientLocal, HttpStatus.OK);
        }
    }




    @DeleteMapping("/recipeIngredients/{tagId}/{ingredientId}")
    public ResponseEntity<RecipeIngredient> deleteIngredient( @PathVariable long recipeId, @PathVariable long ingredientId) {

        if (ingredientSerivce.getIngredientById(ingredientId).isPresent()) {

            recipeIngredientService.deleteRecipeIngredient(recipeId,ingredientId);

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }






}
