package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Category;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.service.CategoryService;
import com.projetb32.koulouwakel.service.IngredientSerivce;
import com.projetb32.koulouwakel.service.PictureService;
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
public class IngredientController {
    private static final Logger log = LoggerFactory.getLogger(IngredientController.class);


    @Autowired
    private IngredientSerivce ingredientSerivce ;

    @Autowired
    private PictureService pictureService ;

    @Autowired
    private CategoryService categoryService ;


    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> retreiveIngredient() {

        if (ingredientSerivce.getAllIngredient().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(ingredientSerivce.getAllIngredient(), HttpStatus.OK);

    }

    @GetMapping("/ingredients/{ingredientId}")
    public ResponseEntity<Optional<Ingredient>> retreiveIngredientById(@PathVariable String ingredientId) {


        if (!ingredientSerivce.getIngredientById(Long.parseLong(ingredientId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(ingredientSerivce.getIngredientById(Long.parseLong(ingredientId)), HttpStatus.OK);
        }
    }

    @PostMapping("/ingredients/{categoryId}/{pictureId}")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient,@PathVariable long categoryId,@PathVariable long pictureId) {
        if (ingredient != null) {
            if (ingredientSerivce.getIngredientByLabel(ingredient.getName()).isPresent()) {
                return ResponseEntity.noContent().build();
            }
        }
        //  log.info("affichage"+activite.getEvenement());
        Ingredient ingredientLocal = ingredientSerivce.addIngredient(ingredient,pictureId,categoryId);

        if (ingredientLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(ingredientLocal, HttpStatus.OK);
        }
    }


    @DeleteMapping("/ingredients/{ingredientsId}")
    public ResponseEntity<Ingredient> deleteIngredient(@PathVariable String ingredientsId) {

        if (ingredientSerivce.getIngredientById(Long.parseLong(ingredientsId)).isPresent()) {

            ingredientSerivce.deleteIngredient(Long.parseLong(ingredientsId));

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }









}
