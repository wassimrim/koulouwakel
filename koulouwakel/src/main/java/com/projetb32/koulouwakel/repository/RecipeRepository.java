package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository <Recipe, Long> {
    public Optional<Recipe> findByTitle(String title);

    public Optional<List<Recipe>> findByDifficulty(String difficulty);

}
