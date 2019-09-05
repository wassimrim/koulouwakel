package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.ConstraintIngredient;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.service.RestrictionService;
import com.projetb32.koulouwakel.service.RestrictioningredientService;
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
public class RestrictioningredientController {


    private static final Logger log = LoggerFactory.getLogger(RestrictionTagController.class);


    @Autowired
    private RestrictionService restrictionService ;

    @Autowired
    private RestrictioningredientService restrictioningredientService ;

    @Autowired
    private IngredientRepository ingredientRepository ;


    @GetMapping("/restrictioningredient")
    public ResponseEntity<List<ConstraintIngredient>> retreiveRestrictiontags() {

        if (restrictioningredientService.getAllRestrictioningredient().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(restrictioningredientService.getAllRestrictioningredient(), HttpStatus.OK);

    }



    @PostMapping("/restrictioningredient/{ingredientId}/{restrictionId}")
    public ResponseEntity<ConstraintIngredient> addIngredient( @PathVariable long ingredientId, @PathVariable long restrictionId) {


        ConstraintIngredient restrictionLocal = restrictioningredientService.addRestrictioningredient(ingredientId,restrictionId);

        if (restrictionLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(restrictionLocal, HttpStatus.OK);
        }
    }




    @DeleteMapping("/restrictioningredient/{ingredientId}/{restrictionId}")
    public ResponseEntity<ConstraintIngredient> deleteIngredient( @PathVariable long ingredientId, @PathVariable long restrictionId) {

        if (restrictionService.getRestrictionById(restrictionId).isPresent()) {

            restrictioningredientService.deleteRestrictioningredient(ingredientId,restrictionId);

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }



}
