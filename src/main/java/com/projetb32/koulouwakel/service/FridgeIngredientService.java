/*package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.FridgeIngredient;
import com.projetb32.koulouwakel.entity.FridgeIngredientPk;
import com.projetb32.koulouwakel.repository.FridgeIngredientRepository;
import com.projetb32.koulouwakel.repository.FridgeRepository;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class FridgeIngredientService {


    private final FridgeRepository fridgeRepository;

    private final FridgeIngredientRepository fridgeIngredientRepository;

    private final IngredientRepository ingredientRepository;

    public FridgeIngredientService(FridgeRepository fridgeRepository, FridgeIngredientRepository fridgeIngredientRepository, IngredientRepository ingredientRepository) {
        this.fridgeRepository = fridgeRepository;
        this.fridgeIngredientRepository = fridgeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
    }


    public FridgeIngredient addFridgeIngredient(FridgeIngredient fridgeIngredient, long fridge_id , long ingredient_id) {

        FridgeIngredientPk pp = new FridgeIngredientPk();
        pp.setFridge(fridgeRepository.findById(fridge_id).get());
        pp.setIngredient(ingredientRepository.findById(ingredient_id).get());
        fridgeIngredient.setFridgeIngredientPk(pp);

        return fridgeIngredientRepository.save(fridgeIngredient);
    }

    public List<FridgeIngredient> getAllFridgeIngredient() {


        return fridgeIngredientRepository.findAll();
    }

    public Optional<FridgeIngredient> getFridgeIngredientById(Long id) {

        return fridgeIngredientRepository.findById(id);

    }



    public void deleteFridgeIngredient(Long category_id,Long restrictiontId) {

        fridgeIngredientRepository.delete(new FridgeIngredient
                (new FridgeIngredientPk(ingredientRepository.findById(category_id).get(),
                        fridgeRepository.findById(restrictiontId).get())));
    }

}
*/