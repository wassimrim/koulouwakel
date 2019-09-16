package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.ConstraintIngredient;
import com.projetb32.koulouwakel.entity.ConstraintIngredientPk;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.RestrictionRepository;
import com.projetb32.koulouwakel.repository.RestrictioningredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class RestrictioningredientService {

    @Autowired
    private RestrictionRepository restrictionRepository;
    @Autowired
    private RestrictioningredientRepository restrictioningredientRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    public ConstraintIngredient addRestrictioningredient(long ingredient_id, long restriction_id) {

        ConstraintIngredient p = new ConstraintIngredient();
        ConstraintIngredientPk pp = new ConstraintIngredientPk();
        pp.setRestriction(restrictionRepository.findById(restriction_id).get());
        pp.setIngredient(ingredientRepository.findById(ingredient_id).get());
        p.setConstraintIngredientPk(pp);

        return restrictioningredientRepository.save(p);
    }

    public List<ConstraintIngredient> getAllRestrictioningredient() {


        return restrictioningredientRepository.findAll();
    }

    public void deleteRestrictioningredient(Long ingredientId, Long restrictiontId) {

        restrictioningredientRepository.delete(new ConstraintIngredient
                (new ConstraintIngredientPk(ingredientRepository.findById(ingredientId).get(),
                        restrictionRepository.findById(restrictiontId).get())));
    }

}
