package com.projetb32.koulouwakel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="category",collectionResourceRel="category")
public interface Category extends PagingAndSortingRepository<Category, Long> {

}
