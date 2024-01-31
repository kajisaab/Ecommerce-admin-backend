package com.ecommerce.ecommerce.feature.vendor.repository;

import com.ecommerce.ecommerce.feature.vendor.entity.VendorAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorAddressRepository extends JpaRepository<VendorAddress, String> {
}
