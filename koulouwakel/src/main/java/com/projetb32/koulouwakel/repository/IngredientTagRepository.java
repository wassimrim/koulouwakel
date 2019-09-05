package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.IngredientTag;
import com.projetb32.koulouwakel.entity.IngredientTagPk;
import com.projetb32.koulouwakel.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientTagRepository extends JpaRepository<IngredientTag, Long> {




}
