package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Category;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.service.CategoryService;
import com.projetb32.koulouwakel.service.IngredientSerivce;
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
    private IngredientSerivce ingredientSerivce;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> retreiveIngredient() {

        List<Ingredient> ingredientList = ingredientSerivce.getAllIngredient();

        if (ingredientList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(ingredientList, HttpStatus.OK);

    }

    @GetMapping("/ingredients/{ingredientId}")
    public ResponseEntity<Optional<Ingredient>> retreiveIngredientById(@PathVariable long ingredientId) {
        Optional<Ingredient> ingredientList = null;
        ingredientList = ingredientSerivce.getIngredientById(ingredientId);
        if (!ingredientList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(ingredientList, HttpStatus.OK);
    }

    @PostMapping("/ingredients/{categoryId}/{pictureId}")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient, @PathVariable long categoryId, @PathVariable long pictureId) {
        Ingredient ingredientLocal = ingredientSerivce.addIngredient(ingredient, pictureId, categoryId);

        if (ingredientLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(ingredientLocal, HttpStatus.OK);

    }


    @DeleteMapping("/ingredients/{ingredientId}")
    public ResponseEntity<Ingredient> deleteIngredient(@PathVariable long ingredientId) {
        ingredientSerivce.deleteIngredient(ingredientId);
        return ResponseEntity.accepted().build();


    }

    @GetMapping("/ingredients/category/{categoryId}")
    public ResponseEntity<List<Ingredient>> getIngredientsByCategory(@PathVariable long categoryId) {
        Category category = categoryService.getCategoryById(categoryId).get();
        return new ResponseEntity<>(ingredientSerivce.getIngredientsByCategory(category), HttpStatus.OK);
    }
}
