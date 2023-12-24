package com.ecommerce.ecommerce.feature.product.entity;

import com.ecommerce.ecommerce.common.DBEntity;
import com.ecommerce.ecommerce.common.PricingEnum;
import com.ecommerce.ecommerce.common.StockStatusEnum;
import com.ecommerce.ecommerce.feature.product.constant.ProductTypeEnum;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AutoCloseable.class)
@Entity
public class Product extends DBEntity {
    @Column()
    private String productCode;

    @Column()
    private String productName;

    @Column()
    private String slug;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private VendorInfo vendorInfo;

    @Column()
    private String quality;

    @Column()
    private Float salePrice;

    @Column()
    private Float purchasePrice;

    @Enumerated(EnumType.STRING)
    private PricingEnum discountType;

    @Column()
    private Float discountValue;

    @Column(columnDefinition = "TINYINT(1) default 0")
    private boolean isTaxable;

    @Enumerated(EnumType.STRING)
    private PricingEnum taxType;

    @Column(columnDefinition = "TINYINT(1) default 0")
    private boolean isPrebooking;

    @Column()
    private String description;

    @Enumerated(EnumType.STRING)
    private StockStatusEnum status;

    @Column()
    private Float packagingFee;

    @Column()
    private String unit;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    private ProductTypeEnum productType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> images = new ArrayList<>();

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private ProductStock productStock;

}
