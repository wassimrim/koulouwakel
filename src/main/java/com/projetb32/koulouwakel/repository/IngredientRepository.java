package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Category;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="ingredient",collectionResourceRel="ingredient")
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

public List<Ingredient> findByCategoryAndPicture(Category c , Picture p);
public List<Ingredient> findByCategory(Category c);
public List<Ingredient> findByPicture(Picture p);


}
