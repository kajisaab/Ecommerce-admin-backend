package com.ecommerce.ecommerce.feature.product.entity;

import com.ecommerce.ecommerce.common.DBEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AutoCloseable.class)
@Entity
public class Color extends DBEntity {

    @Column()
    private String colorCode;

    @Column()
    private String colorName;
}
