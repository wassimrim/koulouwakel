package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.*;

import com.projetb32.koulouwakel.repository.FridgeIngredientGroupRepository;
import com.projetb32.koulouwakel.repository.FridgeRepository;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FridgeIngredientGroupService {

    @Autowired
    FridgeIngredientGroupRepository fridgeIngredientGroupRepository;
    @Autowired
    FridgeRepository fridgeRepository ;
    @Autowired
    IngredientRepository  ingredientRepository ;

    public FridgeIngredientGroup addIngredientToFridge (Long idIngredient , Long idFridge, LocalDate expirationDate , int quantity ){

        Fridge fridge = fridgeRepository.findById(idFridge).get();
        Ingredient  ingredient = ingredientRepository.findById(idIngredient).get();
        FridgeIngredientGroup fridgeIngredientGroup = new FridgeIngredientGroup(new FridgeIngredientId(fridge,ingredient),quantity,expirationDate);

        return fridgeIngredientGroupRepository.save(fridgeIngredientGroup) ;
    }
    public void deleteIngredientFromFridge (Long idIngredient , Long idFridge){

        Fridge fridge = fridgeRepository.findById(idFridge).get();
        Ingredient  ingredient = ingredientRepository.findById(idIngredient).get();
        FridgeIngredientGroup fridgeIngredientGroup = new FridgeIngredientGroup(new FridgeIngredientId(fridge,ingredient));

        fridgeIngredientGroupRepository.delete(fridgeIngredientGroup);


    }
   public FridgeIngredientGroup updateQuantityAndExpirationDateFromFridgeIngredient(long idIngredient , long idFridge, LocalDate expirationDate , int quantity)
   {
       Fridge fridge = fridgeRepository.findById(idFridge).get();
       Ingredient  ingredient = ingredientRepository.findById(idIngredient).get();
       FridgeIngredientGroup fridgeIngredientGroup = fridgeIngredientGroupRepository.findFridgeIngredientGroupByPrimaryKey(new FridgeIngredientId(fridge,ingredient));
       fridgeIngredientGroup.setDateExperationIngredient(expirationDate);
       fridgeIngredientGroup.setQuantityIngredient(quantity);

       return fridgeIngredientGroupRepository.save(fridgeIngredientGroup) ;

   }

    public FridgeIngredientGroup updateQuantityFromFridgeIngredient(long idIngredient , long idFridge,  int quantity)
    {
        Fridge fridge = fridgeRepository.findById(idFridge).get();
        Ingredient  ingredient = ingredientRepository.findById(idIngredient).get();
        FridgeIngredientGroup fridgeIngredientGroup = fridgeIngredientGroupRepository.findFridgeIngredientGroupByPrimaryKey(new FridgeIngredientId(fridge,ingredient));
        fridgeIngredientGroup.setQuantityIngredient(quantity);

        return fridgeIngredientGroupRepository.save(fridgeIngredientGroup) ;

    }

    public FridgeIngredientGroup updateExpirationDateFromFridgeIngredient(long idIngredient , long idFridge, LocalDate expirationDate )
    {
        Fridge fridge = fridgeRepository.findById(idFridge).get();
        Ingredient  ingredient = ingredientRepository.findById(idIngredient).get();
        FridgeIngredientGroup fridgeIngredientGroup = fridgeIngredientGroupRepository.findFridgeIngredientGroupByPrimaryKey(new FridgeIngredientId(fridge,ingredient));
        fridgeIngredientGroup.setDateExperationIngredient(expirationDate);

        return fridgeIngredientGroupRepository.save(fridgeIngredientGroup) ;

    }


    public List<Object> getRecipeFromFridgeContent(long id)
    {
        return fridgeIngredientGroupRepository.getRecipesbyFridgeContent(id);
    }


}
