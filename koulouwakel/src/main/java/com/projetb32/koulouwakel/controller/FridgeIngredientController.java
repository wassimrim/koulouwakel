package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.FridgeIngredientGroup;
import com.projetb32.koulouwakel.service.FridgeIngredientGroupService;
import com.projetb32.koulouwakel.service.FridgeService;
import com.projetb32.koulouwakel.service.IngredientSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class FridgeIngredientController {

    @Autowired
    private FridgeIngredientGroupService fridgeIngredientGroupService;

    @PostMapping("/fridgeingredient/{ingredientId}/{fridgeId}/{quantity}/{expirationDate}")
    public ResponseEntity<FridgeIngredientGroup> addIngredientToFridge(@PathVariable long ingredientId, @PathVariable long fridgeId, @PathVariable int quantity, @PathVariable String expirationDate) {

        FridgeIngredientGroup fridgeingredient = fridgeIngredientGroupService.addIngredientToFridge(ingredientId, fridgeId, LocalDate.parse(expirationDate), quantity);

        if (fridgeingredient == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(fridgeingredient, HttpStatus.OK);

    }


    @DeleteMapping("/fridgeingredient/{ingredientId}/{fridgeId}")
    public ResponseEntity<FridgeIngredientGroup> deleteFridgeIngredient(@PathVariable long ingredientId, @PathVariable long fridgeId) {
        fridgeIngredientGroupService.deleteIngredientFromFridge(ingredientId, fridgeId);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/fridgeingredient/{ingredientId}/{fridgeId}/{quantity}/{expirationDate}")
    public ResponseEntity<FridgeIngredientGroup> updateQuantityAndExpirationDateFromFridgeIngredient(@PathVariable long ingredientId, @PathVariable long fridgeId, @PathVariable int quantity, @PathVariable String expirationDate) {
        return new ResponseEntity<FridgeIngredientGroup>(fridgeIngredientGroupService.updateQuantityAndExpirationDateFromFridgeIngredient(ingredientId, fridgeId, LocalDate.parse(expirationDate), quantity), HttpStatus.OK);
    }

    @PutMapping("/fridgeingredient/updatequantity/{ingredientId}/{fridgeId}/{quantity}")
    public ResponseEntity<FridgeIngredientGroup> updateQuantityFromFridgeIngredient(@PathVariable long ingredientId, @PathVariable long fridgeId, @PathVariable int quantity) {
        return new ResponseEntity<FridgeIngredientGroup>(fridgeIngredientGroupService.updateQuantityFromFridgeIngredient(ingredientId, fridgeId, quantity), HttpStatus.OK);
    }

    @PutMapping("/fridgeingredient/updateexpirationdate/{ingredientId}/{fridgeId}/{expirationDate}")
    public ResponseEntity<FridgeIngredientGroup> updateExpirationDateFromFridgeIngredient(@PathVariable long ingredientId, @PathVariable long fridgeId, @PathVariable String expirationDate) {
        return new ResponseEntity<FridgeIngredientGroup>(fridgeIngredientGroupService.updateExpirationDateFromFridgeIngredient(ingredientId, fridgeId, LocalDate.parse(expirationDate)), HttpStatus.OK);
    }


    @GetMapping("/getrecipes/fridgeid/{fridgeid}")
    public ResponseEntity<List<Object>> getRecipesFromFridgeContent(@PathVariable long fridgeid) {
        return new ResponseEntity<>(fridgeIngredientGroupService.getRecipeFromFridgeContent(fridgeid), HttpStatus.OK);
    }


}
