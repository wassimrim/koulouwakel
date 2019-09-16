package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Recipe;
import com.projetb32.koulouwakel.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "tag", collectionResourceRel = "tag")
public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByLabel(String label);


    @Query(" select  distinct r from Recipe r inner join RecipeIngredient ri" +
            " on r.id = ri.recipeIngredientPk.recipe.id inner join Ingredient i " +
            " on ri.recipeIngredientPk.ingredient.id = i.id inner join IngredientTag it " +
            " on it.ingredientTagPk.ingredient.id = i.id inner join Tag t " +
            " on t.id=it.ingredientTagPk.tag.id" +
            " where t.id = ?1 ")
    public List<Recipe> findRecipesByTagId(long tagId);

}

