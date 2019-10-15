package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.RecipeIngredient;
import com.projetb32.koulouwakel.entity.RecipeIngredientPk;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.RecipeIngredientRepository;
import com.projetb32.koulouwakel.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RecipeIngredientService {

    @Autowired
    private  IngredientRepository ingredientRepository;
    @Autowired
    private  RecipeIngredientRepository recipeIngredientRepository;
    @Autowired
    private  RecipeRepository recipeRepository;

    public RecipeIngredient addRecipeIngredient( long recipe_id, long ingredient_id ) {

        RecipeIngredient p =new RecipeIngredient();
        RecipeIngredientPk pp = new RecipeIngredientPk();
        pp.setIngredient(ingredientRepository.findById(ingredient_id).get());
        pp.setRecipe(recipeRepository.findById(recipe_id).get());
        p.setRecipeIngredientPk(pp);

        return recipeIngredientRepository.save(p);
    }

    public List<RecipeIngredient> getAllRecipeIngredient() {
        return recipeIngredientRepository.findAll();
    }

    public Optional<RecipeIngredient> getRecipeIngredientById(Long id) {

        return recipeIngredientRepository.findById(id);

    }



    public void deleteRecipeIngredient(Long recipeId,Long ingredientId) {

        recipeIngredientRepository.delete(new RecipeIngredient
                (new RecipeIngredientPk(ingredientRepository.findById(ingredientId).get(),
                        recipeRepository.findById(recipeId).get())));
    }

    public List<Ingredient> findIngredientsByRecipeId(Long recipeId)
    {
        return recipeIngredientRepository.findIngredientsByRecipeId(recipeId);
    }

}
