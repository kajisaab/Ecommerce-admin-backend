//package com.ecommerce.ecommerce.ssr.vendorPage.services;
//
//import com.ecommerce.ecommerce.feature.vendor.dto.VendorListDto;
//import com.ecommerce.ecommerce.feature.vendor.repository.VendorInfoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class VendorListService {
//    public VendorInfoRepository vendorInfoRepository;
//
//    @Autowired
//    public VendorListService(VendorInfoRepository vendorInfoRepository){
//        this.vendorInfoRepository = vendorInfoRepository;
//    }
//
//    public List<VendorListDto> getVendorList() {
//        List<VendorListDto> vendorDetailsList = vendorInfoRepository.getAllVendor();
//
//        System.out.println("This is the vendorDetailsList " + vendorDetailsList);
//        return vendorDetailsList;
//    }
//}
