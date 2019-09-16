package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.FridgeIngredientId;
import com.projetb32.koulouwakel.entity.FridgeIngredientGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FridgeIngredientGroupRepository extends JpaRepository<FridgeIngredientGroup, FridgeIngredientId> {

    public FridgeIngredientGroup findFridgeIngredientGroupByPrimaryKey(FridgeIngredientId primarykey);


    @Query("   select   ri.recipeIngredientPk.recipe.id  " +
            "  from     RecipeIngredient ri inner join FridgeIngredientGroup fi " +
            "  on ri.recipeIngredientPk.ingredient.id  = fi.primaryKey.ingredient.id " +
            "  where  fi.primaryKey.fridge.id = ?1  " +
            "  Group by ri.recipeIngredientPk.recipe.id       " +
            "  having   1 > (select   count(ri2.recipeIngredientPk.ingredient.id )" +
            " from  RecipeIngredient ri2 " +
            " where ri2.recipeIngredientPk.recipe.id =  ri.recipeIngredientPk.recipe.id " +
            "             and ri2.recipeIngredientPk.ingredient.id not in ( select distinct fi2.primaryKey.ingredient.id  " +
            "                                                                        from  FridgeIngredientGroup fi2 inner join RecipeIngredient ri3 " +
            "                                                                                on fi2.primaryKey.ingredient.id = ri3.recipeIngredientPk.ingredient.id " +
            "                                                                             where fi2.primaryKey.fridge.id= ?1  )  )     ")

    public List<Object> getRecipesbyFridgeContent(long id);

}

