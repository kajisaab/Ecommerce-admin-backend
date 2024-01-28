package com.ecommerce.ecommerce.feature.vendor.repository;

import com.ecommerce.ecommerce.feature.vendor.dto.VendorDetailDto;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface VendorInfoRepository extends JpaRepository<VendorInfo, String> {
    @Query(value = "SELECT vi.id AS vendor_id, vi.vendor_name, vi.image, COALESCE(vr.rating, 1), vi.contact_no " +
            "FROM vendor_info vi " +
            "LEFT JOIN vendor_review vr ON vi.id = vr.vendor_id", nativeQuery = true)
    List<Map<String, Object>> getAllVendor();

    @Query(value = "SELECT vi.id AS vendor_id, vi.vendor_name, vi.contact_no, vi.area, vi.street, vi.district, vi.state, vi.country, vi.zip_code, vi.slug, vi.vendor_type, vi.status, vi.image, vb.bank_name, vb.account_holder, vb.account_number, vss.facebook_url, twitter_url, instagram_url " +
    "FROM vendor_info vi " +
    "LEFT JOIN vendor_bank_detail vb ON vi.id = vb.vendor_id " +
            "LEFT JOIN vendor_social_setting vss on vi.id = vss.vendor_id" +
            " WHERE vi.id = :id ", nativeQuery = true
    )
    Map<String, Object> getIndividualVendor(@Param(value = "id") String id);

}
