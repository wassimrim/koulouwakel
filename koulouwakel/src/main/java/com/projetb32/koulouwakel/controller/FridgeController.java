package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Fridge;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.User;
import com.projetb32.koulouwakel.repository.UserRepository;
import com.projetb32.koulouwakel.service.FridgeService;
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
public class FridgeController {
    private static final Logger log = LoggerFactory.getLogger(IngredientController.class);


    @Autowired
    private FridgeService fridgeService ;



    private UserPrinciple userPrinciple ;


    @GetMapping("/fridge")
    public ResponseEntity<List<Fridge>> retreiveFridge() {

        if (fridgeService.getAllFridge().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(fridgeService.getAllFridge(), HttpStatus.OK);

    }

    @GetMapping("/fridge/{fridgeId}")
    public ResponseEntity<Optional<Fridge>> retreiveFridgeById(@PathVariable String fridgeId) {


        if (!fridgeService.getFridgeById(Long.parseLong(fridgeId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(fridgeService.getFridgeById(Long.parseLong(fridgeId)), HttpStatus.OK);
        }
    }

    @GetMapping("/fridges/user/{userId}")
    public ResponseEntity<Optional<List<Fridge>>> retrieveFridgesByUserId(@PathVariable long userId) {

        if (!fridgeService.getFridgeByUserId(userId).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(fridgeService.getFridgeByUserId(userId), HttpStatus.OK);
        }
    }


    @PostMapping("/fridge/{userId}")
    public ResponseEntity<Fridge> addIngredient(@RequestBody Fridge fridge,@PathVariable long userId  ) {


        Fridge fridgeLocal = fridgeService.addFridge(fridge,userId);

        if (fridgeLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(fridgeLocal, HttpStatus.OK);
        }
    }


    @DeleteMapping("/fridge/{fridgeId}")
    public ResponseEntity<Fridge> deleteIngredient(@PathVariable String fridgeId) {

        if (fridgeService.getFridgeById(Long.parseLong(fridgeId)).isPresent()) {

            fridgeService.deleteFridge(Long.parseLong(fridgeId));

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }

    }
        /* fridge ingredient */

        @PostMapping("/fridgeingredient/{ingredientId}/{fridgeId}")
        public ResponseEntity<Fridge> addIngredientToFridge(@PathVariable long ingredientId, @PathVariable long fridgeId)
        {
            Fridge fridgeLocal = fridgeService.addIngredientToFridge(ingredientId,fridgeId);

            if (fridgeLocal == null) {
                return ResponseEntity.noContent().build();
            } else {
                return new ResponseEntity<>(fridgeLocal, HttpStatus.OK);
            }
        }


    @PostMapping("/fridgeingredient/{fridgeId}")
    public /*ResponseEntity<Fridge>*/ void addIngredientToFridge(@RequestBody Ingredient [] ingredients, @PathVariable long fridgeId)
    {
        log.info("wwwww   ========"+ingredients.toString());
      //  Fridge fridgeLocal = fridgeService.addIngredientsToFridge(ingredients,fridgeId);

       /* if (fridgeLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(fridgeLocal, HttpStatus.OK);
        }*/
    }

        @GetMapping("/fridgeingredient")
        public String[] getAllFridgeIngredient()
        {
            return fridgeService.getAllFridgeIngredient();
        }





    }