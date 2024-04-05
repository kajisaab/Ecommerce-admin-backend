package com.ecommerce.ecommerce.feature.auth.repository;

import com.ecommerce.ecommerce.feature.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    @Query(value = "SELECT COUNT(*) > 0 FROM user_details WHERE phone_number = :phone AND is_deleted = 0 ", nativeQuery = true)
    Long existsByPhoneNumber(String phone);
}
