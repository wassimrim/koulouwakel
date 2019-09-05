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
    private FamilyService familyService ;

    @Autowired
    private RecipeService recipeService ;

    private UserPrinciple userPrinciple ;


    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> retreiveRecipe() {

        if (recipeService.getAllRecipe().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(recipeService.getAllRecipe(), HttpStatus.OK);

    }

    @GetMapping("/recipes/{recipeId}")
    public ResponseEntity<Optional<Recipe>> retreiveRecipeById(@PathVariable String recipeId) {


        if (!recipeService.getRecipeById(Long.parseLong(recipeId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(recipeService.getRecipeById(Long.parseLong(recipeId)), HttpStatus.OK);
        }
    }


    @GetMapping("/recipes/{recipeDifficulty}")
    public ResponseEntity<Optional<Recipe>> retreiveRecipeByDifficulty(@PathVariable String recipeDifficulty) {


        if (!recipeService.getRecipeByDifficulty(recipeDifficulty).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(recipeService.getRecipeByDifficulty(recipeDifficulty), HttpStatus.OK);
        }
    }


    @GetMapping("/recipes/{recipeTitle}")
    public ResponseEntity<Optional<Recipe>> retreiveRecipeByTitle(@PathVariable String recipeTitle) {


        if (!recipeService.getRecipeByTitle(recipeTitle).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(recipeService.getRecipeByTitle(recipeTitle), HttpStatus.OK);
        }
    }

    @PostMapping("/recipes/{family_id}/{user_id}")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe,@PathVariable long family_id,@PathVariable long user_id) {

        //  log.info("affichage"+activite.getEvenement());
        Recipe recipeLocal = recipeService.addRecipe(recipe,family_id,user_id);

        if (recipeLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(recipeLocal, HttpStatus.OK);
        }
    }

   /* @PostMapping("/recipes/{family_id}/{user_id}")
    public ResponseEntity<Recipe> addRecipej(@RequestBody Recipe recipe,@PathVariable long family_id,@PathVariable long user_id) {

        //  log.info("affichage"+activite.getEvenement());
        Recipe recipeLocal = recipeService.addRecipe(recipe,family_id,user_id);

        if (recipeLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(recipeLocal, HttpStatus.OK);
        }
    }*/


    @DeleteMapping("/recipes/{recipeId}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable String recipeId) {

        if (recipeService.getRecipeById(Long.parseLong(recipeId)).isPresent()) {

            recipeService.deleteRecipe(Long.parseLong(recipeId));

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }









}
