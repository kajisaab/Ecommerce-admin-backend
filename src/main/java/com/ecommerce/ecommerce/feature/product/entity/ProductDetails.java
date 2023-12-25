package com.ecommerce.ecommerce.feature.product.entity;

import com.ecommerce.ecommerce.common.DBEntity;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AutoCloseable.class)
@Entity()
public class ProductDetails extends DBEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_details_size", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "size_id"))
    private Set<Size> sizes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_details_color", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "color_id"))
    private Set<Color> colors = new HashSet<>();

    @Column()
    private Integer totalQuantity;

    @Column()
    private Integer remainingQuantity;

    @Column(columnDefinition = "TINYINT(1) default 0")
    private boolean isAvailable;

}
