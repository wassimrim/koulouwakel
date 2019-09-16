package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.ConstraintCategory;
import com.projetb32.koulouwakel.entity.ConstraintCategoryPk;
import com.projetb32.koulouwakel.repository.CategoryRepository;
import com.projetb32.koulouwakel.repository.RestrictionCategoryRepository;
import com.projetb32.koulouwakel.repository.RestrictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RestrictionCategoryService {

@Autowired
    private  RestrictionRepository restrictionRepository;
@Autowired
    private  RestrictionCategoryRepository restrictionCategoryRepository;
@Autowired
    private  CategoryRepository categoryRepository;




    public ConstraintCategory addRestrictionCategory(  long category_id ,long restriction_id ) {

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

    public void deleteRestrictionCategory(Long category_id,Long restrictiontId) {

        restrictionCategoryRepository.delete(new ConstraintCategory
                (new ConstraintCategoryPk(categoryRepository.findById(category_id).get(),
                        restrictionRepository.findById(restrictiontId).get())));
    }

}
