package com.ecommerce.ecommerce.feature.product.entity;

import com.ecommerce.ecommerce.common.DBEntity;
import jakarta.persistence.*;
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
public class ProductImage extends DBEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column()
    private String images;
}
