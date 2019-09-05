package com.projetb32.koulouwakel.repository;

import java.util.Optional;

import com.projetb32.koulouwakel.entity.Role;
import com.projetb32.koulouwakel.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
