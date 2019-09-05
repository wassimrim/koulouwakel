package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Fridge;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.User;
import com.projetb32.koulouwakel.repository.FridgeRepository;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FridgeService {



    private final UserRepository userRepository;

    private final FridgeRepository fridgeRepository;
    private final IngredientRepository ingredientRepository;

    public FridgeService(UserRepository userRepository, FridgeRepository fridgeRepository,IngredientRepository ingredientRepository) {
        this.userRepository = userRepository;
        this.fridgeRepository = fridgeRepository;
        this.ingredientRepository=ingredientRepository;
    }


    public Fridge addFridge(Fridge fridge, long user_id) {

        fridge.setUser(userRepository.findById(user_id).get());


        return fridgeRepository.save(fridge);
    }

    public List<Fridge> getAllFridge() {


        return fridgeRepository.findAll();
    }

    public Optional<Fridge> getFridgeById(Long id) {

        return fridgeRepository.findById(id);

    }

    public Optional<Fridge> getFridgeByLabel(String name) {

        return fridgeRepository.findByName(name);
    }

    public void deleteFridge(Long id) {

        fridgeRepository.deleteById(id);

    }

    public Optional<List<Fridge>> getFridgeByUserId(long idUser)
    {
        User user = userRepository.findById(idUser).get();
        return   fridgeRepository.findFridgeByUser(user);
    }

    public Optional<List<Fridge>> getFridgeByUserName(String userName)
    {
        User user = userRepository.findByUsername(userName).get();
        return   fridgeRepository.findFridgeByUser(user);
    }


    /* fridgeingredient */
    public Fridge addIngredientToFridge(Long idIngredient , Long idFridge)
    {
        Ingredient ingredient = ingredientRepository.findById(idIngredient).get();

        Fridge fridge = fridgeRepository.findById(idFridge).get();

        fridge.getFridgeIngredients().add(ingredient);

        return fridgeRepository.save(fridge);
    }
  //  public Fridge addIngredientToFridgeByUserName

    public Fridge addIngredientsToFridge(long[] idIngredients , long idFridge)
    {
        Ingredient ingredient = null;
        Fridge fridge = null;
        fridge = fridgeRepository.findById(idFridge).get();
        for( int i =0; i<= idIngredients.length;i++)
        {
            ingredient = ingredientRepository.findById(idIngredients[i]).get();
            fridge.getFridgeIngredients().add(ingredient);
        }

        return fridgeRepository.save(fridge);
    }

    public String[] getAllFridgeIngredient()
    {
        return fridgeRepository.findAllFridgeIngredient();
    }


}
