package com.ecommerce.ecommerce.feature.auth.repository;

import com.ecommerce.ecommerce.feature.auth.entity.OtpSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpSettingRepository extends JpaRepository<OtpSetting, String> {
}
