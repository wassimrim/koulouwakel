package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Category;
import com.projetb32.koulouwakel.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path="recipe",collectionResourceRel="recipe")
public interface SearchRecipeRepository extends JpaRepository<Recipe, Long> {

  /*  @Query("   SELECT   ri.recipeIngredientPk.recipe.id  \r\n" +
            "	FROM  RecipeIngredient ri  \r\n" +
           " GROUP BY  ri.recipeIngredientPk.recipe.id ,ri.recipeIngredientPk.ingredient.id \r \n"+
            "	HAVING  ri.recipeIngredientPk.ingredient.id =   ( select DISTINCT fi.fridgeIngredientPk.ingredient.id \r\n " +
                                                                   "FROM FridgeIngredient fi  \r\n" +
                                                                   "WHERE fi.fridgeIngredientPk.fridge.id = ?1  )")
    public List<Recipe> findRecipeListFromFridgeAllIngredients( Long id);*/



}
