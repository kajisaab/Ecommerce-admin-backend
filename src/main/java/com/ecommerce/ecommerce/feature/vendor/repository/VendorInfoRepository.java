package com.ecommerce.ecommerce.feature.vendor.repository;

import com.ecommerce.ecommerce.feature.vendor.dto.VendorListDto;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendorInfoRepository extends JpaRepository<VendorInfo,String> {
    @Query(value = "SELECT vi.id AS vendor_id, vi.vendor_name, vi.image, vr.rating, vi.contact_no " +
    "FROM vendor_info vi " +
    "JOIN vendor_review vr ON vi.id = vr.vendor_id", nativeQuery = true)
    List<VendorListDto> getAllVendor();

}
