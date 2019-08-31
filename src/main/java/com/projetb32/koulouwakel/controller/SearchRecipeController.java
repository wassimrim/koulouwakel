/*package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Category;
import com.projetb32.koulouwakel.entity.Recipe;
import com.projetb32.koulouwakel.service.CategoryService;
import com.projetb32.koulouwakel.service.SearchRecipeService;
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
public class SearchRecipeController {
    private static final Logger log = LoggerFactory.getLogger(SearchRecipeController.class);

    @Autowired
    private SearchRecipeService searchRecipeService ;


    @GetMapping("/searchrecipeingredient/{idFridge}")
    public ResponseEntity<List<Recipe>> retreiveRecipesFromFridge(@PathVariable String idFridge) {

        return new ResponseEntity<>(searchRecipeService.searchRecipeFromFridge(Long.parseLong(idFridge)), HttpStatus.OK);

    }






}*/
