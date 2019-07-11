package com.projetb32.koulouwakel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="picture",collectionResourceRel="picture")
public interface Picture  extends PagingAndSortingRepository<Picture, Long> {
}
