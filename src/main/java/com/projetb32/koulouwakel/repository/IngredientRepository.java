package com.projetb32.koulouwakel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="ingredient",collectionResourceRel="ingredient")
public interface Ingredient extends PagingAndSortingRepository<Ingredient, Long> {

}
