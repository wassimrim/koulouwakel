package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IngredientTagRepository extends JpaRepository<IngredientTag, Long> {


}
