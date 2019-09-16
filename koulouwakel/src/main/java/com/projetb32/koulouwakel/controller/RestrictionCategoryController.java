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
    private RestrictionCategoryService restrictionCategoryService;




    @GetMapping("/restrictionCategory")
    public ResponseEntity<List<ConstraintCategory>> retreiveRestrictionCategorys() {

        List<ConstraintCategory> listConstraintCategory = null;
        listConstraintCategory = restrictionCategoryService.getAllRestrictionCategory();
        if (listConstraintCategory.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(listConstraintCategory, HttpStatus.OK);

    }


    @PostMapping("/restrictionCategory/{categoryId}/{restrictionId}")
    public ResponseEntity<ConstraintCategory> addRestrictionCategory(@PathVariable long categoryId, @PathVariable long restrictionId) {


        ConstraintCategory restrictionLocal = restrictionCategoryService.addRestrictionCategory(categoryId, restrictionId);

        if (restrictionLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(restrictionLocal, HttpStatus.OK);

    }


    @DeleteMapping("/restrictionCategory/{categoryId}/{restrictionId}")
    public ResponseEntity<ConstraintCategory> deleteRestrictionCategory(@PathVariable long categoryId, @PathVariable long restrictionId) {

        restrictionCategoryService.deleteRestrictionCategory(categoryId, restrictionId);

        return ResponseEntity.accepted().build();


    }


}
