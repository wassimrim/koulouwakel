package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FamilyRepository extends JpaRepository <Family, Long> {
    Optional<Family> findByName(String name);
    Optional<Family> findByParentFamily(String parent);



}
