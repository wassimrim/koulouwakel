package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Category;
import com.projetb32.koulouwakel.entity.Recipe;
import com.projetb32.koulouwakel.repository.CategoryRepository;
//import com.projetb32.koulouwakel.repository.FridgeIngredientRepository;
/*import com.projetb32.koulouwakel.repository.SearchRecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SearchRecipeService {

   public static final  Logger l =LoggerFactory.getLogger(SearchRecipeService.class);

    private final SearchRecipeRepository searchRecipeRepository ;

    public SearchRecipeService(SearchRecipeRepository searchRecipeRepository) {
        super();
        this.searchRecipeRepository = searchRecipeRepository;
    }

    public List<Recipe> searchRecipeFromFridge( Long fridgeId) {


        l.info("my Variable"+fridgeId.toString());
        return  searchRecipeRepository.findRecipeListFromFridgeAllIngredients(fridgeId);
    }
}
*/