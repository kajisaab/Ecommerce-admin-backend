package com.ecommerce.ecommerce.feature.vendor.repository;

import com.ecommerce.ecommerce.feature.vendor.dto.VendorListDto;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import com.ecommerce.ecommerce.feature.vendor.responseDto.VendorListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface VendorInfoRepository extends JpaRepository<VendorInfo, String> {
    @Query(value = "SELECT vi.id AS vendor_id, vi.vendor_name, vi.image, COALESCE(vr.rating, 0), vi.contact_no " +
            "FROM vendor_info vi " +
            "LEFT JOIN vendor_review vr ON vi.id = vr.vendor_id", nativeQuery = true)
    List<Map<String, Object>> getAllVendor();

}
