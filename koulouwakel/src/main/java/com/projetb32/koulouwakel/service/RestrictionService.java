package com.projetb32.koulouwakel.service;


import com.projetb32.koulouwakel.entity.Restriction;
import com.projetb32.koulouwakel.repository.RestrictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RestrictionService {

    @Autowired
    private RestrictionRepository restrictionRepository;


    public Restriction addRestriction(Restriction restriction) {

        return restrictionRepository.save(restriction);
    }

    public List<Restriction> getAllRestriction() {


        return restrictionRepository.findAll();
    }

    public Optional<Restriction> getRestrictionById(Long id) {

        return restrictionRepository.findById(id);

    }

    public Optional<Restriction> getRestrictionByLabel(String label) {

        return restrictionRepository.findByLabel(label);
    }

    public void deleteTag(Long id) {

        restrictionRepository.deleteById(id);

    }

    public Restriction updateTag(Long id, Restriction restriction) {
        Restriction restrictionFound = restrictionRepository.findById(id).get();
        restrictionFound.setLabel(restriction.getLabel());
        restrictionRepository.save(restrictionFound);
        return restrictionFound;
    }


}
