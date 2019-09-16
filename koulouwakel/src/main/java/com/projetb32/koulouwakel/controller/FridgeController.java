package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Fridge;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.Ingredients;
import com.projetb32.koulouwakel.entity.User;
import com.projetb32.koulouwakel.repository.UserRepository;
import com.projetb32.koulouwakel.service.FridgeService;
import com.projetb32.koulouwakel.service.UserPrinciple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class FridgeController {
    private static final Logger log = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private FridgeService fridgeService;



  /*  @GetMapping("/fridge")
    public ResponseEntity<List<Fridge>> retreiveFridge() {
        List<Fridge> fridgeList = null;
        fridgeList = fridgeService.getAllFridge();
        if (fridgeList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(fridgeList, HttpStatus.OK);

    }*/

    @GetMapping("/fridge/{fridgeId}") /* cette methode presente une faille de securité  on doit la modifier*/
    public ResponseEntity<Optional<Fridge>> retreiveFridgeById(@PathVariable long fridgeId) {

        Optional<Fridge> fridgeList = null;
        fridgeList = fridgeService.getFridgeById(fridgeId);
        if (!fridgeList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(fridgeList, HttpStatus.OK);

    }

    @GetMapping("/fridge/userId/{userId}")
    public ResponseEntity<List<Fridge>> retrieveFridgesByUserId(@PathVariable long userId) {

        List<Fridge> fridgeList = null;
        fridgeList = fridgeService.getFridgeByUserId(userId);

        if (fridgeList == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(fridgeService.getFridgeByUserId(userId), HttpStatus.OK);

    }


    @GetMapping("/fridge/userName/{userName}")
    public ResponseEntity<List<Fridge>> retrieveFridgesByUserName(@PathVariable String userName) {
        List<Fridge> fridgeList = null;
        fridgeList = fridgeService.getFridgeByUserName(userName);
        if (fridgeList == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(fridgeService.getFridgeByUserName(userName), HttpStatus.OK);

    }


    @PostMapping("/fridge/{userId}")
    public ResponseEntity<Fridge> addIngredient(@RequestBody Fridge fridge, @PathVariable long userId) {


        Fridge fridgeLocal = fridgeService.addFridge(fridge, userId);

        if (fridgeLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(fridgeLocal, HttpStatus.OK);

    }


    @DeleteMapping("/fridge/{fridgeId}")
    public ResponseEntity<Fridge> deleteIngredient(@PathVariable long fridgeId) {
        fridgeService.deleteFridge(fridgeId);
        return ResponseEntity.noContent().build();

    }
}
