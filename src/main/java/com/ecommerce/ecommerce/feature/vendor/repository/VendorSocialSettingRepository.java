package com.ecommerce.ecommerce.feature.vendor.repository;

import com.ecommerce.ecommerce.feature.vendor.entity.VendorSocialSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;
import java.util.Optional;

public interface VendorSocialSettingRepository extends JpaRepository<VendorSocialSetting, String> {

    @Query(value  = "SELECT * FROM vendor_social_setting where vendor_id = :id", nativeQuery = true)
    Optional<Map<String, Object>> getVendorSocialSettingByVendorId(String id);
}
