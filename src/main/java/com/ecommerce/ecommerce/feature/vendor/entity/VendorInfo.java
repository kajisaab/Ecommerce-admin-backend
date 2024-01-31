package com.ecommerce.ecommerce.feature.vendor.entity;

import com.ecommerce.ecommerce.common.DBEntity;
import com.ecommerce.ecommerce.common.StatusEnum;
import com.ecommerce.ecommerce.feature.product.entity.Product;
import com.ecommerce.ecommerce.feature.vendor.Constant.VendorTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class VendorInfo extends DBEntity {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String contactNo;

    @Column(nullable = false)
    private String vendorBusinessName;

    @Column()
    private String slug;

    @Enumerated(EnumType.STRING)
    private VendorTypeEnum vendorType;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column()
    private String image;

    @OneToOne(mappedBy = "vendorInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id") // Assuming "vendor_id" is the foreign key column in vendor_social_setting
    private VendorSocialSetting vendorSocialSetting;

    @OneToOne(mappedBy = "vendorInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private VendorReview vendorReview;

    @OneToOne(mappedBy = "vendorInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private VendorBankDetail vendorBankDetail;

    @OneToOne(mappedBy = "vendorInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private VendorAddress vendorAddress;

}
