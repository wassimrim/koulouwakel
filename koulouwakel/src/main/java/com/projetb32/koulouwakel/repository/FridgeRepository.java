package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Fridge;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.entity.Recipe;
import com.projetb32.koulouwakel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface FridgeRepository extends JpaRepository<Fridge, Long> {

    public Optional<Fridge> findByName(String name);

    public Optional<Fridge> findById(Long id);

    public List<Fridge> findFridgeByUser(User user);

}
