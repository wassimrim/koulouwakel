package com.projetb32.koulouwakel.service;


import com.projetb32.koulouwakel.entity.Family;
import com.projetb32.koulouwakel.repository.FamilyRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FamilyService {


    private final FamilyRepository familyRepository ;

    public FamilyService(FamilyRepository familyRepository) {
        super();
        this.familyRepository = familyRepository;
    }

    public Family addFamily(Family family) {
        return familyRepository.save(family);
    }

    public List<Family> getAllFamily() {


        return familyRepository.findAll();
    }

    public Optional<Family> getFamilyById(Long id) {

        return familyRepository.findById(id);

    }

    public Optional<Family> getFamilyByName(String name) {

        return familyRepository.findByName(name);
    }


    public Optional<Family> getFamilysByParentFamily(String parentFamily) {

        return familyRepository.findByParentFamily(parentFamily);
    }


    public void deleteFamily(Long id) {

        familyRepository.deleteById(id);

    }





}
