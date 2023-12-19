package com.ecommerce.ecommerce.feature.auth.repository;

import com.ecommerce.ecommerce.feature.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
