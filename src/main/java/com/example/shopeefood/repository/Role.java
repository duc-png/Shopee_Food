package com.example.shopeefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Role extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(String roleName);
}
