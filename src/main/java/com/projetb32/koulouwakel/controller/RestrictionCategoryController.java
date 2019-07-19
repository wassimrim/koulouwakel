package com.projetb32.koulouwakel.controller;



import com.projetb32.koulouwakel.entity.ConstraintCategory;
import com.projetb32.koulouwakel.service.CategoryService;
import com.projetb32.koulouwakel.service.RestrictionCategoryService;
import com.projetb32.koulouwakel.service.RestrictionService;
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
public class RestrictionCategoryController {


    private static final Logger log = LoggerFactory.getLogger(RestrictionCategoryController.class);


    @Autowired
    private RestrictionService restrictionService ;

    @Autowired
    private RestrictionCategoryService restrictionCategoryService ;

    @Autowired
    private CategoryService categoryService ;


    @GetMapping("/restrictionCategory")
    public ResponseEntity<List<ConstraintCategory>> retreiveRestrictiontags() {

        if (restrictionCategoryService.getAllRestrictionCategory().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(restrictionCategoryService.getAllRestrictionCategory(), HttpStatus.OK);

    }



    @PostMapping("/restrictionCategory/{categoryId}/{restrictionId}")
    public ResponseEntity<ConstraintCategory> addIngredient(@RequestBody ConstraintCategory constraintCategory, @PathVariable long categoryId, @PathVariable long restrictionId) {


        ConstraintCategory restrictionLocal = restrictionCategoryService.addRestrictionCategory(constraintCategory ,categoryId,restrictionId);

        if (restrictionLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(restrictionLocal, HttpStatus.OK);
        }
    }




    @DeleteMapping("/restrictionCategory/{categoryId}/{restrictionId}")
    public ResponseEntity<ConstraintCategory> deleteIngredient( @PathVariable long categoryId, @PathVariable long restrictionId) {

        if (restrictionService.getRestrictionById(restrictionId).isPresent()) {

            restrictionCategoryService.deleteRestrictionCategory(categoryId,restrictionId);

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }




}
