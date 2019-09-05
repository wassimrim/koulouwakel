/*package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.FridgeIngredient;
import com.projetb32.koulouwakel.service.FridgeIngredientService;
import com.projetb32.koulouwakel.service.FridgeService;
import com.projetb32.koulouwakel.service.IngredientSerivce;
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
public class FridgeIngredientController {



    private static final Logger log = LoggerFactory.getLogger(FridgeIngredientController.class);


    @Autowired
    private FridgeService fridgeService ;

    @Autowired
    private FridgeIngredientService fridgeIngredientService ;

    @Autowired
    private IngredientSerivce ingredientSerivce ;


    @GetMapping("/fridgeingredient")
    public ResponseEntity<List<FridgeIngredient>> retreiveFridgeIngredients() {

        if (fridgeIngredientService.getAllFridgeIngredient().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(fridgeIngredientService.getAllFridgeIngredient(), HttpStatus.OK);

    }



    @PostMapping("/fridgeingredient/{ingredientId}/{fridgeId}")
    public ResponseEntity<FridgeIngredient> addFridgeIngredient(@RequestBody FridgeIngredient fridgeIngredient, @PathVariable long ingredientId, @PathVariable long fridgeId) {


        FridgeIngredient fridgeingredientLocal = fridgeIngredientService.addFridgeIngredient(fridgeIngredient ,ingredientId,fridgeId);

        if (fridgeingredientLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(fridgeingredientLocal, HttpStatus.OK);
        }
    }




    @DeleteMapping("/fridgeingredient/{ingredientId}/{fridgeId}")
    public ResponseEntity<FridgeIngredient> deleteFridgeIngredient( @PathVariable long ingredientId, @PathVariable long fridgeId) {

        if (ingredientSerivce.getIngredientById(ingredientId).isPresent()) {

            fridgeIngredientService.deleteFridgeIngredient(ingredientId,fridgeId);

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }



}
*/