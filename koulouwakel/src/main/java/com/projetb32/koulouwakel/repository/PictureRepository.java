package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "picture", collectionResourceRel = "picture")
public interface PictureRepository extends JpaRepository<Picture, Long> {

    Optional<Picture> findByLabel(String label);
}
