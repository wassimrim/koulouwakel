package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.FridgeIngredientId;
import com.projetb32.koulouwakel.entity.FridgeIngredientGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FridgeIngredientGroupRepository extends JpaRepository<FridgeIngredientGroup, FridgeIngredientId> {


   // public Optional<List<FridgeIngredientGroup>> findFridgeIngredientGroupsById(Fridge f);


    public FridgeIngredientGroup findFridgeIngredientGroupByPrimaryKey(FridgeIngredientId primarykey);


   @Query("  select  distinct ri.recipeIngredientPk.recipe.id  " +
           " from RecipeIngredient ri inner join FridgeIngredientGroup fi  " +
           " on ri.recipeIngredientPk.ingredient.id  = fi.primaryKey.ingredient.id " +
           "where  fi.primaryKey.fridge.id = ?1  " +
           "Group by ri.recipeIngredientPk.recipe.id" +
           " having count(ri.recipeIngredientPk.ingredient.id)=(select count(fi.primaryKey.ingredient.id) from  fi  where fi.primaryKey.fridge.id = ?1 )")
    public List<Object> getRecipesbyFridgeContent(long id);

}
