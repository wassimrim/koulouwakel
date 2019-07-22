package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Fridge;
import com.projetb32.koulouwakel.repository.FridgeRepository;
import com.projetb32.koulouwakel.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FridgeService {



    private final UserRepository userRepository;

    private final FridgeRepository fridgeRepository;

    public FridgeService(UserRepository userRepository, FridgeRepository fridgeRepository) {
        this.userRepository = userRepository;
        this.fridgeRepository = fridgeRepository;
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


}
