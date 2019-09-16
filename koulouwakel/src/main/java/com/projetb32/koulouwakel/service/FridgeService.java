package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Fridge;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.Ingredients;
import com.projetb32.koulouwakel.entity.User;
import com.projetb32.koulouwakel.repository.FridgeRepository;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FridgeService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FridgeRepository fridgeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;


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

    public List<Fridge> getFridgeByUserId(long idUser) {
        User user = userRepository.findById(idUser).get();
        return fridgeRepository.findFridgeByUser(user);
    }

    public List<Fridge> getFridgeByUserName(String userName) {
        User user = userRepository.findByUsername(userName).get();
        return fridgeRepository.findFridgeByUser(user);
    }


}
