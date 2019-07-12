package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.repository.CategoryRepository;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.PictureRepository;
import org.springframework.stereotype.Component;

@Component
public class IngredientSerivce {

    private final PictureRepository pictureRepository;

    private final CategoryRepository categoryRepository;

    private final IngredientRepository IngredientRepository;


    public IngredientSerivce(PictureRepository pictureRepository, CategoryRepository categoryRepository, com.projetb32.koulouwakel.repository.IngredientRepository ingredientRepository) {
        this.pictureRepository = pictureRepository;
        this.categoryRepository = categoryRepository;
        this.IngredientRepository = ingredientRepository;
    }


}
