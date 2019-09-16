package com.projetb32.koulouwakel.controller;

import com.projetb32.koulouwakel.entity.IngredientTag;
import com.projetb32.koulouwakel.service.IngredientSerivce;
import com.projetb32.koulouwakel.service.IngredientTagService;
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
public class IngredientTagController {

    @Autowired
    private IngredientTagService ingredientTagService;

    @GetMapping("/ingredienttags")
    public ResponseEntity<List<IngredientTag>> retreiveIngredientTag() {
        return new ResponseEntity<>(ingredientTagService.getAllIngredientTag(), HttpStatus.OK);

    }


    @PostMapping("/ingredienttags/{tagId}/{ingredientId}")
    public ResponseEntity<IngredientTag> addIngredientTag(@PathVariable long tagId, @PathVariable long ingredientId) {


        IngredientTag ingredientLocal = ingredientTagService.addIngredientTag(tagId, ingredientId);

        if (ingredientLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(ingredientLocal, HttpStatus.OK);
    }


    @DeleteMapping("/ingredienttags/{tagId}/{ingredientId}")
    public ResponseEntity<IngredientTag> deleteIngredientTag(@PathVariable long tagId, @PathVariable long ingredientId) {
        ingredientTagService.deleteIngredientTag(tagId, ingredientId);
        return ResponseEntity.accepted().build();
    }
}
