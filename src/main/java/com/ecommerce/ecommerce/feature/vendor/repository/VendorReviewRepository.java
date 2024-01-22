package com.ecommerce.ecommerce.feature.vendor.repository;

import com.ecommerce.ecommerce.feature.vendor.entity.VendorReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorReviewRepository extends JpaRepository<VendorReview, String> {
}
