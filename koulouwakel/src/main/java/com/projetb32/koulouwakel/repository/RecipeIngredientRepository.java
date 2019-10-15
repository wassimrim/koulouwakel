package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository <RecipeIngredient,Long> {

    @Query(" select  distinct  i " +
            "from RecipeIngredient ri inner join Ingredient i" +
            " on i.id = ri.recipeIngredientPk.ingredient.id   " +
            " where  ri.recipeIngredientPk.recipe.id = 1")
    List<Ingredient> findIngredientsByRecipeId(long idRecipe);
}
