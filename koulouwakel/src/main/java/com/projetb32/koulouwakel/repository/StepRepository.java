package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StepRepository extends JpaRepository <Step,Long> {
    Optional<List<Step>> findByRecipe_Id(Long id);

}
