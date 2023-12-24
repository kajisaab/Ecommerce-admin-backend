package com.ecommerce.ecommerce.feature.auth.repository;

import com.ecommerce.ecommerce.feature.auth.entity.UserCredential;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential, String> {
    @Query(value = "SELECT * from user_credential WHERE id = :userId",nativeQuery = true)
    List<UserCredential> findByUserId(@Param("userId") String userId);
}
