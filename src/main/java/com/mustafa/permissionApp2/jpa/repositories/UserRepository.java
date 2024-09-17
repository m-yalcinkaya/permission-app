package com.mustafa.permissionApp2.jpa.repositories;

import com.mustafa.permissionApp2.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
