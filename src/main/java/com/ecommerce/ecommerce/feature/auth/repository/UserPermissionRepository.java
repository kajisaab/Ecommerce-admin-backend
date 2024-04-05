package com.ecommerce.ecommerce.feature.auth.repository;

import com.ecommerce.ecommerce.feature.auth.entity.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserPermissionRepository extends JpaRepository<UserPermission, String> {

//    @Query(value = "SELECT * FROM user_permission WHERE user_role = :userRole", nativeQuery = true)
    @Query(value = "SELECT * FROM user_permission WHERE user_role = :userRole", nativeQuery = true)
    UserPermission getPermissionByRole(String userRole);
}
