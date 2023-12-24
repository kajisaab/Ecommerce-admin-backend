package com.ecommerce.ecommerce.feature.vendor.entity;

import com.ecommerce.ecommerce.common.DBEntity;
import jakarta.persistence.*;
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
public class VendorReview extends DBEntity {
    @Column()
    private Integer rating;

    @Column()
    private String review;

    @Column()
    private String reply;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    private VendorInfo vendorInfo;

}
