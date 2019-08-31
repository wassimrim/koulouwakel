package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Fridge;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface FridgeRepository extends JpaRepository<Fridge, Long> {

    public Optional<Fridge> findByName(String name);

      /* @Query(" SELECT   All  \r\n" +
            "	FROM  RecipeIngredient  \r\n" +
           "WHERE  r.id = ?1  ")
    public /*List<Recipe> String findRecipe(Long id);*/
      public Optional<Fridge>findById(Long id);

}
