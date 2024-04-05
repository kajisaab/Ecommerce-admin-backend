package com.ecommerce.ecommerce.feature.product.entity;

import com.ecommerce.ecommerce.common.DBEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AutoCloseable.class)
@Entity
public class SubCategory extends DBEntity {

    @Column()
    private String subCategoryName;

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


}
