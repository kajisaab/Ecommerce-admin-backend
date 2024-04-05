package com.ecommerce.ecommerce.feature.vendor.entity;


import com.ecommerce.ecommerce.common.DBEntity;
import com.ecommerce.ecommerce.feature.auth.entity.User;
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
public class VendorAddress extends DBEntity {

    @Column()
    private String country;

    @Column()
    private String state;

    @Column()
    private String province;

    @Column()
    private String wardNo;

    @Column()
    private String street;

    @Column()
    private String municipality;

    @Column()
    private String ruralMunicipality;

    @Column()
    private String zipCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    private VendorInfo vendorInfo;

}

