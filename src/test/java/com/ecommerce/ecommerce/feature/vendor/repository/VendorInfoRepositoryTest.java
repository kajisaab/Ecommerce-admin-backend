package com.ecommerce.ecommerce.feature.vendor.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class VendorInfoRepositoryTest {

    @Autowired
    private VendorInfoRepository vendorInfoRepository;

    @BeforeEach
    void setup(){

    }
}
