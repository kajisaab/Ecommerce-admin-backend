package com.ecommerce.ecommerce.ssr.vendorPage.services;

import com.ecommerce.ecommerce.feature.vendor.dto.VendorInfoProjection;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VendorListService {
    public VendorDetailsRepository vendorDetailsRepository;

    @Autowired
    public VendorListService(VendorDetailsRepository vendorDetailsRepository){
        this.vendorDetailsRepository = vendorDetailsRepository;
    }

    public List<VendorInfoProjection> getVendorList() {
        List<VendorInfoProjection> vendorDetailsList = vendorDetailsRepository.getAllVendor();

        System.out.println("This is the vendorDetailsList " + vendorDetailsList);
        return vendorDetailsList;
    }
}
