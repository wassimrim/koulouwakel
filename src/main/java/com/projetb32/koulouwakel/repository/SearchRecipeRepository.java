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

    @Query("	SELECT r.id ,r.country,r.difficulty,r.nbPerson ,r.prepDuration,r.title,r.family.id,r.user.id \r\n" +
            "	FROM  RecipeIngredient ri , Ingredient i, FridgeIngredient fi,Fridge f ,Recipe r  \r\n" +
            "	where  r.id = ri.recipeIngredientPk.recipe.id and  ri.recipeIngredientPk.ingredient.id = i.id and i.id= fi.fridgeIngredientPk.ingredient.id   \r\n" +
            "	and f.id =fi.fridgeIngredientPk.fridge.id  and f.id = ?1 " +
            "	GROUP BY r.id ")
    public List<Recipe> findRecipeList ( Long id);



}
