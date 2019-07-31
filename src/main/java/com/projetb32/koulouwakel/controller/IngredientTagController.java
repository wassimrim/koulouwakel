package com.projetb32.koulouwakel.controller;

import com.projetb32.koulouwakel.entity.IngredientTag;
import com.projetb32.koulouwakel.service.IngredientSerivce;
import com.projetb32.koulouwakel.service.IngredientTagService;
import com.projetb32.koulouwakel.service.TagService;
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
public class IngredientTagController {
    private static final Logger log = LoggerFactory.getLogger(IngredientController.class);


    @Autowired
    private IngredientSerivce ingredientSerivce ;

    @Autowired
    private IngredientTagService ingredientTagService ;

    @Autowired
    private TagService tagService ;


    @GetMapping("/ingredienttags")
    public ResponseEntity<List<IngredientTag>> retreiveIngredient() {

        if (ingredientTagService.getAllIngredientTag().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(ingredientTagService.getAllIngredientTag(), HttpStatus.OK);

    }



    @PostMapping("/ingredienttags/{tagId}/{ingredientId}")
    public ResponseEntity<IngredientTag> addIngredient(/*@RequestBody IngredientTag ingredientTag,*/ @PathVariable long tagId, @PathVariable long ingredientId) {


        IngredientTag ingredientLocal = ingredientTagService.addIngredientTag(/*ingredientTag,*/tagId,ingredientId);

        if (ingredientLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(ingredientLocal, HttpStatus.OK);
        }
    }




    @DeleteMapping("/ingredienttags/{tagId}/{ingredientId}")
    public ResponseEntity<IngredientTag> deleteIngredient( @PathVariable long tagId, @PathVariable long ingredientId) {

        if (ingredientSerivce.getIngredientById(ingredientId).isPresent()) {

            ingredientTagService.deleteIngredientTag(tagId,ingredientId);

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }





}
