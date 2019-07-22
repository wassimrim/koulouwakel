package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface FridgeRepository extends JpaRepository<Fridge, Long> {

    public Optional<Fridge> findByName(String name);

}
