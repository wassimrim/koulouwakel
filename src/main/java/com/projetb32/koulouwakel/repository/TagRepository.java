package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="tag",collectionResourceRel="tag")
public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByLabel(String label);

}
