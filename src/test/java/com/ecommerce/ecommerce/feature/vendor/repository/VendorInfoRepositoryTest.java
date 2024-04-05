package com.ecommerce.ecommerce.feature.vendor.repository;

import com.ecommerce.ecommerce.common.StatusEnum;
import com.ecommerce.ecommerce.feature.auth.repository.UserDetailsRepository;
import com.ecommerce.ecommerce.feature.vendor.Constant.VendorTypeEnum;
import com.ecommerce.ecommerce.feature.vendor.dto.VendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.dto.VendorUserRequestDto;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import com.ecommerce.ecommerce.feature.vendor.requestDto.OnboardVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.usecase.OnboardVendorUsecase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class VendorInfoRepositoryTest {

    @Autowired
    private VendorInfoRepository vendorInfoRepositoryTest;

    @Autowired
    private VendorSocialSettingRepository vendorSocialSettingRepositoryTest;

    @Autowired
    private VendorBankDetailsRepository vendorBankDetailsRepositoryTest;

    @Autowired
    private  UserDetailsRepository userDetailsRepositoryTest;

    @Autowired
    private OnboardVendorUsecase onboardVendorUsecaseTest;

   @Test
    void itShouldOnboardVendor(){
       //given

       VendorRequestDto vendorTest = new VendorRequestDto();

       vendorTest.setAccountHolder("Aman Khadka");
       vendorTest.setVendorEmail("amankhadka101@gmail.com");
       vendorTest.setVendorType("Service Provider");
       vendorTest.setCountry("Nepal");
       vendorTest.setContactNumber("1212121212");
       vendorTest.setProvince("Bagmati");
       vendorTest.setImage(null);
       vendorTest.setState("Kathmandu");
       vendorTest.setStreet(null);
       vendorTest.setMunicipality("Kathmandu");
       vendorTest.setRuralMunicipality("Balaju");
       vendorTest.setVendorBusinessName("Merchant BusinessName");
       vendorTest.setVendorUserName("Kaji saab");
       vendorTest.setZipCode(null);
       vendorTest.setFacebookUrl(null);
       vendorTest.setTwitterUrl(null);
       vendorTest.setAccountNumber("981298129812");
       vendorTest.setBankName("Global IME");

       VendorUserRequestDto vendorUserTest = new VendorUserRequestDto();

       vendorUserTest.setFirstName("Kaji");
       vendorUserTest.setLastName("saab");
       vendorUserTest.setWardNo("04");
       vendorUserTest.setContactNumber("9876543211");
       vendorUserTest.setCountry("Nepal");
       vendorUserTest.setProvince("Bagmati");
       vendorUserTest.setState("State");
       vendorUserTest.setStreet(null);
       vendorUserTest.setMunicipality("Kathmandu");
       vendorUserTest.setRuralMunicipality(null);

       OnboardVendorRequestDto onboardVendorTest = new OnboardVendorRequestDto();
       onboardVendorTest.setVendor(vendorTest);
       onboardVendorTest.setUser(vendorUserTest);

       boolean userExists = userDetailsRepositoryTest.existsByEmail(vendorTest.getVendorEmail());

       // then
       assertThat(userExists).isFalse();

       VendorInfo vendorInfo = onboardVendorUsecaseTest.mapToVendorInfo(onboardVendorTest);

       // Assert the result
       assertEquals(onboardVendorTest.getVendor().getVendorEmail(), vendorInfo.getEmail());
       assertEquals(onboardVendorTest.getVendor().getVendorBusinessName(), vendorInfo.getVendorBusinessName());
       assertEquals(onboardVendorTest.getVendor().getContactNumber(), vendorInfo.getContactNo());
       assertEquals("abc", vendorInfo.getSlug()); // Assuming this is always set to "abc"
       assertEquals(VendorTypeEnum.fromDisplayName(onboardVendorTest.getVendor().getVendorType()), vendorInfo.getVendorType());
       assertEquals(StatusEnum.PENDING, vendorInfo.getStatus());
       assertEquals(onboardVendorTest.getVendor().getImage(), vendorInfo.getImage());

   }
}
