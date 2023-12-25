package com.ecommerce.ecommerce.feature.vendor.repository;

import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorDetailsRepository extends JpaRepository<VendorInfo,String> {

}
