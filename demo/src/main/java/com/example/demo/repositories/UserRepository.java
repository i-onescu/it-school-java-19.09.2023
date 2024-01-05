package com.example.demo.repositories;

import com.example.demo.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserById(Long id);

    // using the naming convention
    List<User> findUsersByName(String name);

    // using explicit JPQL
    @Query("SELECT u FROM users u WHERE u.name = :name")
    List<User> findUsersByNameJPQL(String name);

    // using native SQL
    @Query(value = "SELECT * FROM users WHERE name = :name", nativeQuery = true)
    List<User> findUsersByNameNative(String name);
}
