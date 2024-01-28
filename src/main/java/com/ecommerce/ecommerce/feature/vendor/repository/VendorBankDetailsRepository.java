package com.ecommerce.ecommerce.feature.vendor.repository;

import com.ecommerce.ecommerce.feature.vendor.entity.VendorBankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;
import java.util.Optional;

public interface VendorBankDetailsRepository extends JpaRepository<VendorBankDetail, String> {

    @Query(value  = "SELECT * FROM vendor_bank_detail where vendor_id = :id", nativeQuery = true)
    Optional<Map<String, Object>>getVendorbankDetailsBVendorId(String id);
}
