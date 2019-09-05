package com.projetb32.koulouwakel.repository;
import com.projetb32.koulouwakel.entity.PictureRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="picturerecipe",collectionResourceRel="picturerecipe")
public interface PictureRecipeRepository extends JpaRepository<PictureRecipe, Long> {

Optional<PictureRecipe> findByLabel(String label);
}
