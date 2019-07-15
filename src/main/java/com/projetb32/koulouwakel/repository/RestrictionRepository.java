package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Restriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="restriction",collectionResourceRel="restriction")
public interface RestrictionRepository extends JpaRepository<Restriction, Long> {


    Optional<Restriction> findByLabel(String label);
}
