package com.projetb32.koulouwakel.service;


import com.projetb32.koulouwakel.entity.IngredientTag;
import com.projetb32.koulouwakel.entity.IngredientTagPk;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.IngredientTagRepository;
import com.projetb32.koulouwakel.repository.TagRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IngredientTagService {

    private final IngredientRepository ingredientRepository;

    private final IngredientTagRepository ingredientTagRepository;

    private final TagRepository tagRepository;


    public IngredientTagService(IngredientRepository ingredientRepository, IngredientTagRepository ingredientTagRepository, TagRepository tagRepository) {
        super();
        this.ingredientRepository = ingredientRepository;
        this.ingredientTagRepository = ingredientTagRepository;
        this.tagRepository = tagRepository;
    }


    public IngredientTag addIngredientTag(/*IngredientTag ingredientTag,*/ long ingredient_id , long tag_id) {

        IngredientTag p =new IngredientTag();
        IngredientTagPk pp = new IngredientTagPk();
        pp.setIngredient(ingredientRepository.findById(ingredient_id).get());
        pp.setTag(tagRepository.findById(tag_id).get());
        p.setIngredientTagPk(pp);

        return ingredientTagRepository.save(p);
    }

    public List<IngredientTag> getAllIngredientTag() {


        return ingredientTagRepository.findAll();
    }

    public Optional<IngredientTag> getIngredientTagById(Long id) {

        return ingredientTagRepository.findById(id);

    }



    public void deleteIngredientTag(Long tagId,Long ingredientId) {

        ingredientTagRepository.delete(new IngredientTag
                (new IngredientTagPk(tagRepository.findById(tagId).get(),
                        ingredientRepository.findById(ingredientId).get())));
    }
}
