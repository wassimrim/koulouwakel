package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.ConstraintCategory;
import com.projetb32.koulouwakel.entity.ConstraintCategoryPk;
import com.projetb32.koulouwakel.repository.CategoryRepository;
import com.projetb32.koulouwakel.repository.RestrictionCategoryRepository;
import com.projetb32.koulouwakel.repository.RestrictionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RestrictionCategoryService {


    private final RestrictionRepository restrictionRepository;

    private final RestrictionCategoryRepository restrictionCategoryRepository;

    private final CategoryRepository categoryRepository;

    public RestrictionCategoryService(RestrictionRepository restrictionRepository, RestrictionCategoryRepository restrictionCategoryRepository, CategoryRepository categoryRepository) {
        this.restrictionRepository = restrictionRepository;
        this.restrictionCategoryRepository = restrictionCategoryRepository;
        this.categoryRepository = categoryRepository;
    }


    public ConstraintCategory addRestrictionCategory(ConstraintCategory constraintCategory, long restriction_id , long category_id) {

        ConstraintCategory p =new ConstraintCategory();
        ConstraintCategoryPk pp = new ConstraintCategoryPk();
        pp.setRestriction(restrictionRepository.findById(restriction_id).get());
        pp.setCategory(categoryRepository.findById(category_id).get());
        p.setConstraintCategoryPk(pp);

        return restrictionCategoryRepository.save(p);
    }

    public List<ConstraintCategory> getAllRestrictionCategory() {


        return restrictionCategoryRepository.findAll();
    }

    public Optional<ConstraintCategory> getRestrictionCategoryById(Long id) {

        return restrictionCategoryRepository.findById(id);

    }



    public void deleteRestrictionCategory(Long category_id,Long restrictiontId) {

        restrictionCategoryRepository.delete(new ConstraintCategory
                (new ConstraintCategoryPk(categoryRepository.findById(category_id).get(),
                        restrictionRepository.findById(restrictiontId).get())));
    }

}
