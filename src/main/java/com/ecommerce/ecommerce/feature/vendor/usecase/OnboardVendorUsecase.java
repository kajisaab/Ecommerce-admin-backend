package com.ecommerce.ecommerce.feature.vendor.usecase;

import com.ecommerce.ecommerce.common.StatusEnum;
import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.validation.ValidationUtils;
import com.ecommerce.ecommerce.email.EmailService;
import com.ecommerce.ecommerce.feature.auth.entity.User;
import com.ecommerce.ecommerce.feature.auth.entity.UserAddress;
import com.ecommerce.ecommerce.feature.auth.entity.UserCredential;
import com.ecommerce.ecommerce.feature.auth.enumConstant.RoleEnum;
import com.ecommerce.ecommerce.feature.auth.enumConstant.UserTypeEnum;
import com.ecommerce.ecommerce.feature.auth.repository.UserAddressRepository;
import com.ecommerce.ecommerce.feature.auth.repository.UserCredentialRepository;
import com.ecommerce.ecommerce.feature.auth.repository.UserDetailsRepository;
import com.ecommerce.ecommerce.feature.auth.requestDto.SignupUsecaseRequestDto;
import com.ecommerce.ecommerce.feature.auth.responseDto.SignupResponse;
import com.ecommerce.ecommerce.feature.auth.service.GeneratePassword;
import com.ecommerce.ecommerce.feature.auth.usecase.SignupUsecase;
import com.ecommerce.ecommerce.feature.vendor.Constant.VendorTypeEnum;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorAddress;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorBankDetail;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorSocialSetting;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorAddressRepository;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorBankDetailsRepository;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorInfoRepository;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorSocialSettingRepository;
import com.ecommerce.ecommerce.feature.vendor.requestDto.OnboardVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.OnboardVendorResponseDto;
import com.ecommerce.ecommerce.feature.vendor.service.OnboardVendorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class OnboardVendorUsecase implements OnboardVendorService {

    private final VendorInfoRepository vendorInfoRepository;
    private final VendorSocialSettingRepository vendorSocialSettingRepository;
    private final VendorBankDetailsRepository vendorBankDetailsRepository;
    private final SignupUsecase signupUsecase;
    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserCredentialRepository userCredentialRepository;
    private final UserAddressRepository userAddressRepository;
    private final VendorAddressRepository vendorAddressRepository;
    private final EmailService emailService;

    @Override
    public OnboardVendorResponseDto onboardVendor(OnboardVendorRequestDto vendorDetailsRequest) {
        String violations = ValidationUtils.validate(vendorDetailsRequest);
        if(!Objects.isNull(violations)) {
            throw new BadRequestException(violations);
        }

        if(vendorDetailsRequest.getVendor().getMunicipality() == null && vendorDetailsRequest.getVendor().getRuralMunicipality() == null ){
            throw new BadRequestException("Municipality or RuralMunicipality is required");
        }

        this.signupUsecase.isNewUser(vendorDetailsRequest.getVendor().getVendorEmail(), vendorDetailsRequest.getUser().getContactNumber());

        // Map the Dto to the entities
        VendorInfo vendorInfoDTO = mapToVendorInfo(vendorDetailsRequest);

        VendorInfo vendorInfo = vendorInfoRepository.save(vendorInfoDTO);

        // VendorBankDetail
        VendorBankDetail bankDetail = vendorInfo.getVendorBankDetail();
        bankDetail.setVendorInfo(vendorInfo);
        vendorBankDetailsRepository.save(bankDetail);

        // VendorSocialSetting
        VendorSocialSetting socialSetting = vendorInfo.getVendorSocialSetting();
        socialSetting.setVendorInfo(vendorInfo);
        vendorSocialSettingRepository.save(socialSetting);

//         Save Vendor Address
        VendorAddress vendorAddress = vendorInfo.getVendorAddress();
        vendorAddress.setVendorInfo(vendorInfo);
        vendorAddressRepository.save(vendorAddress);


        String vendorPassword = GeneratePassword.generate(9);

        User user = User.builder().firstName(vendorDetailsRequest.getUser().getFirstName()).lastName(vendorDetailsRequest.getUser().getLastName()).email(vendorDetailsRequest.getVendor().getVendorEmail()).userName(vendorDetailsRequest.getUser().getUserName()).role(RoleEnum.ADMIN).userType(UserTypeEnum.VENDOR).phoneNumber(vendorDetailsRequest.getUser().getContactNumber()).build();

        User savedUser = userDetailsRepository.save(user);

        UserCredential userCredential = new UserCredential();
        userCredential.setUserDetails(savedUser);
        userCredential.setPassword(passwordEncoder.encode((vendorPassword)));
        userCredentialRepository.save(userCredential);

        UserAddress userAddress = getUserAddress(vendorDetailsRequest, savedUser);
        userAddressRepository.save(userAddress);


//        if(response.getMessage().equals("Successfully Created user")){
////            this.emailService.sendHtmlEmail();
//            System.out.println("Send the password to the email from here which is " + vendorPassword);
//        }

        return new OnboardVendorResponseDto("Successfully Created Vendor");
    }

    private static UserAddress getUserAddress(OnboardVendorRequestDto vendorDetailsRequest, User savedUser) {
        UserAddress userAddress = new UserAddress();
        userAddress.setState(vendorDetailsRequest.getUser().getState());
        userAddress.setProvince(vendorDetailsRequest.getUser().getProvince());
        userAddress.setWardNo(vendorDetailsRequest.getUser().getWardNo());
        userAddress.setStreet(vendorDetailsRequest.getUser().getStreet());
        userAddress.setMunicipality(vendorDetailsRequest.getUser().getMunicipality());
        userAddress.setRuralMunicipality(vendorDetailsRequest.getUser().getRuralMunicipality());
        userAddress.setZipCode(vendorDetailsRequest.getUser().getZipCode());
        userAddress.setUserDetails(savedUser);
        return userAddress;
    }

    public VendorInfo mapToVendorInfo(OnboardVendorRequestDto dto) {
        // Mapping logic...

        // setting the vendor Info details;
        VendorInfo vendorInfo = new VendorInfo();
        vendorInfo.setEmail(dto.getVendor().getVendorEmail());
        vendorInfo.setVendorBusinessName(dto.getVendor().getVendorBusinessName());
        vendorInfo.setContactNo(dto.getVendor().getContactNumber());
        vendorInfo.setSlug("abc");
        vendorInfo.setVendorType(VendorTypeEnum.fromDisplayName(dto.getVendor().getVendorType()));
        vendorInfo.setStatus(StatusEnum.PENDING);
        vendorInfo.setImage(dto.getVendor().getImage()); // replace the hardcode value to dto.getImage();

        // setting the vendor bank details;
        VendorBankDetail vendorBankDetail = new VendorBankDetail();
        vendorBankDetail.setBankName(dto.getVendor().getBankName());
        vendorBankDetail.setAccountHolder(dto.getVendor().getAccountHolder());
        vendorBankDetail.setAccountNumber(dto.getVendor().getAccountNumber());
        vendorBankDetail.setVendorInfo(vendorInfo);
        vendorInfo.setVendorBankDetail(vendorBankDetail);

        // setting the vendor social setting
        VendorSocialSetting vendorSocialSetting = new VendorSocialSetting();
        vendorSocialSetting.setFacebookUrl(dto.getVendor().getFacebookUrl());
        vendorSocialSetting.setInstagramUrl(dto.getVendor().getInstagramUrl());
        vendorSocialSetting.setTwitterUrl(dto.getVendor().getTwitterUrl());
        vendorSocialSetting.setVendorInfo(vendorInfo);
        vendorInfo.setVendorSocialSetting(vendorSocialSetting);

        // setting the vendor address
        VendorAddress vendorAddress = new VendorAddress();
        vendorAddress.setState(dto.getVendor().getState());
        vendorAddress.setProvince(dto.getVendor().getProvince());
        vendorAddress.setWardNo(dto.getVendor().getWardNo());
        vendorAddress.setStreet(dto.getVendor().getStreet());
        vendorAddress.setMunicipality(dto.getVendor().getMunicipality());
        vendorAddress.setRuralMunicipality(dto.getVendor().getRuralMunicipality());
        vendorAddress.setZipCode(dto.getVendor().getZipCode());
        vendorAddress.setVendorInfo(vendorInfo);
        vendorInfo.setVendorAddress(vendorAddress);

        return vendorInfo;
    }
}
