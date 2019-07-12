package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Category;
import com.projetb32.koulouwakel.service.CategoryService;
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
public class CategoryController {
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService ;


    @GetMapping("/categorys")
    public ResponseEntity<List<Category>> retreivePictures() {

        if (categoryService.getAllCategory().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);

    }

    @GetMapping("/categorys/{categoryId}")
    public ResponseEntity<Optional<Category>> retreiveCategoryById(@PathVariable String categoryId) {


        if (!categoryService.getCategoryById(Long.parseLong(categoryId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(categoryService.getCategoryById(Long.parseLong(categoryId)), HttpStatus.OK);
        }
    }

    @PostMapping("/categorys")
    public ResponseEntity<Category> addPicture(@RequestBody Category category) {
        if (category != null) {
            if (categoryService.getCategoryBytype(category.getType()).isPresent()) {
                return ResponseEntity.noContent().build();
            }
        }
        //  log.info("affichage"+activite.getEvenement());
        Category categoryLocal = categoryService.addCategory(category);

        if (categoryLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(categoryLocal, HttpStatus.OK);
        }
    }

    @PutMapping("/categorys/{categorysId}")
    public ResponseEntity<Category> updateCategory(@PathVariable String categorysId, @RequestBody Category category) {

        if (categoryService.getCategoryById(category.getId()).isPresent()) {

            Category pictureLocal = categoryService.updateCategory(Long.parseLong(categorysId), category);

            if (pictureLocal == null) {
                return ResponseEntity.noContent().build();
            } else {
                return new ResponseEntity<>(pictureLocal, HttpStatus.OK);
            }
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/categorys/{categorysId}")
    public ResponseEntity<Category> deletePicture(@PathVariable String categorysId) {

        if (categoryService.getCategoryById(Long.parseLong(categorysId)).isPresent()) {

            categoryService.deleteCategory(Long.parseLong(categorysId));

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }




}
