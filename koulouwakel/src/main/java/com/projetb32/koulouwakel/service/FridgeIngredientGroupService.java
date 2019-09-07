package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Fridge;
import com.projetb32.koulouwakel.entity.FridgeIngredientGroup;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.repository.FridgeIngredientGroupRepositiry;
import com.projetb32.koulouwakel.repository.FridgeRepository;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FridgeIngredientGroupService {

    @Autowired
    FridgeIngredientGroupRepositiry fridgeIngredientGroupRepositiry;
    @Autowired
    FridgeRepository fridgeRepository ;
    @Autowired
    IngredientRepository  ingredientRepository ;

    public FridgeIngredientGroup addIngredientToFridge (Long idIngredient , Long idFridge){

        Fridge fridge = fridgeRepository.findById(idFridge).get();
        Ingredient  ingredient = ingredientRepository.findById(idIngredient).get();
        FridgeIngredientGroup fridgeIngredientGroup = new FridgeIngredientGroup();
         fridgeIngredientGroup.setFridge(fridge);
         fridgeIngredientGroup.setIngredient(ingredient);

       return fridgeIngredientGroupRepositiry.save(fridgeIngredientGroup) ;
    }
}
