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
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AutoCloseable.class)
@Entity
public class Size extends DBEntity {
    @Column()
    private String size;
}
