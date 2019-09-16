package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Category;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.Picture;
import com.projetb32.koulouwakel.repository.CategoryRepository;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IngredientSerivce {

    @Autowired
    private  PictureRepository pictureRepository;

    @Autowired
    private  CategoryRepository categoryRepository;

    @Autowired
    private  IngredientRepository IngredientRepository;


    public Ingredient addIngredient(Ingredient ingredient, long picture_id , long category_id) {
        ingredient.setCategory(categoryRepository.findById(category_id).get());
        ingredient.setPicture(pictureRepository.findById(picture_id).get());
        return IngredientRepository.save(ingredient);
    }

    public List<Ingredient> getAllIngredient() {
        return IngredientRepository.findAll();
    }

    public Optional<Ingredient> getIngredientById(Long id) {
        return IngredientRepository.findById(id);

    }

    public Optional<Ingredient> getIngredientByLabel(String name) {
        return IngredientRepository.findByName(name);
    }

    public void deleteIngredient(Long id) {
        IngredientRepository.deleteById(id);

    }


    public List<Ingredient> getIngredientsByCategory(Category category)
    {
      return   IngredientRepository.findIngredientByCategory(category);
    }
    public  List<Ingredient>findIngredientByCategory(String nameCatgorie){
        Category category = categoryRepository.findByType(nameCatgorie).get();
        return  IngredientRepository.findByCategory(category) ;
    }

}
