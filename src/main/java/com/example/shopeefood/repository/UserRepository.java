package com.example.shopeefood.repository;

import com.example.shopeefood.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query methods can be defined here if needed
    // For example:
    // Optional<User> findByEmail(String email);

    // You can also define methods for pagination and sorting
    // Page<User> findAll(Pageable pageable);

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);



}
