package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Category;
import com.projetb32.koulouwakel.entity.Picture;
import org.springframework.stereotype.Component;
import com.projetb32.koulouwakel.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryService {

    private final CategoryRepository categoryRepository ;

    public CategoryService(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategory() {


        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {

        return categoryRepository.findById(id);

    }

    public Optional<Category> getCategoryBytype(String type) {

        return categoryRepository.findBytype(type);
    }

    public void deleteCategory(Long id) {

        categoryRepository.deleteById(id);

    }

    public Category updateCategory(Long id,Category category) {


        Category categoryFound = categoryRepository.findById(id).get();


        categoryFound.setType(category.getType());
        categoryRepository.save(categoryFound);

        return categoryFound;
    }









}
