package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="category",collectionResourceRel="category")
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findBytype(String type);

}
