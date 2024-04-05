package com.ecommerce.ecommerce.feature.vendor.repository;

import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface VendorInfoRepository extends JpaRepository<VendorInfo, String> {

    // This is how the pagination is done
    @Query(value = "SELECT vi.id AS vendor_id, vi.vendor_business_name, vi.image, COALESCE(vr.rating, 1) AS rating, vi.contact_no " +
            "FROM vendor_info vi " +
            "LEFT JOIN vendor_review vr ON vi.id = vr.vendor_id " +
            "WHERE vi.vendor_business_name LIKE %:keyword% OR vi.contact_no LIKE %:keyword%",
            countQuery = "SELECT count(*) FROM vendor_info vi WHERE vi.vendor_name LIKE %:keyword% OR vi.contact_no LIKE %:keyword%",
            nativeQuery = true)
    Page<Map<String, Object>> getAllVendor(@Param("keyword") String keyword, Pageable pageable);

    @Query(value = "SELECT vi.id AS vendor_id, vi.vendor_business_name, vi.contact_no, vi.slug, vi.vendor_type, vi.status, vi.email, vi.image, vb.bank_name, vb.account_holder, vb.account_number, vss.facebook_url, vss.twitter_url, vss.instagram_url, va.municipality, va.province, va.rural_municipality, va.state, va.street, va.ward_no, va.zip_code, va.country " +
            "FROM vendor_info vi " +
            "LEFT JOIN vendor_bank_detail vb ON vi.id = vb.vendor_id " +
            "LEFT JOIN vendor_social_setting vss on vi.id = vss.vendor_id " +
            "LEFT JOIN vendor_address va on vi.id = va.vendor_id" +
            " WHERE vi.id = :id ", nativeQuery = true
    )
    Map<String, Object> getIndividualVendor(@Param(value = "id") String id);
    
}
