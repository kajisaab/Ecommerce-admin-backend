//package com.ecommerce.ecommerce.ssr.vendorPage.vendorPageController;
//
//import com.ecommerce.ecommerce.feature.auth.entity.User;
//import com.ecommerce.ecommerce.ssr.vendorPage.services.VendorListService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/vendorPage")
//public class VendorPageController {
//
//    public VendorListService vendorListService;
//
//    @Autowired
//    public VendorPageController(VendorListService vendorListService){
//        this.vendorListService = vendorListService;
//    }
//
////    @GetMapping("")
////    public String getVendor(Model model){
////        model.addAttribute("pageTitle", "Vendor");
////
//////        to fetch the vendor card details on the page load
////        List<VendorListDtoabc> cardDetails = vendorListService.getVendorList();
////        if(cardDetails != null && !cardDetails.isEmpty()){
////            model.addAttribute("vendors", cardDetails);
////        }else {
////            model.addAttribute("vendors", new ArrayList<>());
////        }
////        System.out.println("This is the vendor list " + cardDetails );
////        return "vendorPage";
////    }
////
////    @GetMapping("/add-vendors")
////    public String addVendor(Model model){
////        model.addAttribute("pageTitle", "Add Vendor");
////        model.addAttribute("user", new User());
////        return "addVendorPage";
////    }
////
////    @PostMapping("/add-vendors")
////    public String processMultiStepForm(@ModelAttribute("user") User user,
////                                       @RequestParam("_page") int currentPage) {
////        // Handle form data for each step
////        switch (currentPage) {
////            case 0:
////                // Process personal information
////                System.out.println("This is first step");
////                break;
////            case 1:
////                // Process address information
////                break;
////            case 2:
////                // Process final step (review and submit)
////                break;
////        }
////
////        return "redirect:/vendorPage/add-vendors?step=" + (currentPage + 1);
////    }
////
////    @GetMapping("/cards")
////    public ResponseEntity<List<VendorListDtoabc>> getCards(Model model, @RequestParam(name = "sort", defaultValue = "asc") String sortOrder) {
////        List<VendorListDtoabc> cardDetails = vendorListService.getVendorList();
////        if(cardDetails != null && !cardDetails.isEmpty()){
////            model.addAttribute("vendors", cardDetails);
////        }else {
////            model.addAttribute("vendors", new ArrayList<>());
////        }
////        System.out.println("This is the vendor list " + cardDetails );
////        Optional<VendorInfoProjection> vendorDetails = VendorDetailsRepository.getAllVendor();
//
////                // Sort the cards based on the provided sortOrder (asc or desc)
////                cardList.sort((card1, card2) -> {
////                    if ("asc".equals(sortOrder)) {
////                        return card1.getName().compareTo(card2.getName());
////                    } else {
////                        return card2.getName().compareTo(card1.getName());
////                    }
////                });
//
////        return ResponseEntity.ok(cardDetails);
////        model.addAttribute("cards", cardDetails);
////    }
//}
