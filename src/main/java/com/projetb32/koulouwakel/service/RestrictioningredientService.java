package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.ConstraintIngredient;
import com.projetb32.koulouwakel.entity.ConstraintIngredientPk;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.RestrictionRepository;
import com.projetb32.koulouwakel.repository.RestrictioningredientRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class RestrictioningredientService {


    private final RestrictionRepository restrictionRepository;

    private final RestrictioningredientRepository restrictioningredientRepository;

    private final IngredientRepository ingredientRepository;

    public RestrictioningredientService(RestrictionRepository restrictionRepository, RestrictioningredientRepository restrictioningredientRepository, IngredientRepository ingredientRepository) {
        this.restrictionRepository = restrictionRepository;
        this.restrictioningredientRepository = restrictioningredientRepository;
         this.ingredientRepository = ingredientRepository;
     }


    public ConstraintIngredient addRestrictioningredient( long ingredient_id, long restriction_id ) {

        ConstraintIngredient p =new ConstraintIngredient();
        ConstraintIngredientPk pp = new ConstraintIngredientPk();
        pp.setRestriction(restrictionRepository.findById(restriction_id).get());
        pp.setIngredient(ingredientRepository.findById(ingredient_id).get());
        p.setConstraintIngredientPk(pp);

        return restrictioningredientRepository.save(p);
    }

    public List<ConstraintIngredient> getAllRestrictioningredient() {


        return restrictioningredientRepository.findAll();
    }

    public Optional<ConstraintIngredient> getRestrictioningredientById(Long id) {

        return restrictioningredientRepository.findById(id);

    }



    public void deleteRestrictioningredient(Long ingredientId,Long restrictiontId) {

        restrictioningredientRepository.delete(new ConstraintIngredient
                (new ConstraintIngredientPk(ingredientRepository.findById(ingredientId).get(),
                        restrictionRepository.findById(restrictiontId).get())));
    }

}
