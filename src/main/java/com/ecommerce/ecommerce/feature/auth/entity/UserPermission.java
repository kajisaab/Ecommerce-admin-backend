package com.ecommerce.ecommerce.feature.auth.entity;

import com.ecommerce.ecommerce.common.DBEntity;
import com.ecommerce.ecommerce.feature.auth.enumConstant.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@Entity
@AllArgsConstructor
@EntityListeners(AutoCloseable.class)
public class UserPermission extends DBEntity {

    @Enumerated(EnumType.STRING)
    private RoleEnum userRole;

    @Column(columnDefinition = "TEXT")
    private String permission;
}
