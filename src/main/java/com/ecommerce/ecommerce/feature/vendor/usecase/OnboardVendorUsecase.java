package com.ecommerce.ecommerce.feature.vendor.usecase;

import com.ecommerce.ecommerce.common.StatusEnum;
import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.validation.ValidationUtils;
import com.ecommerce.ecommerce.email.EmailService;
import com.ecommerce.ecommerce.feature.auth.requestDto.SignupUsecaseRequestDto;
import com.ecommerce.ecommerce.feature.auth.responseDto.SignupResponse;
import com.ecommerce.ecommerce.feature.auth.service.GeneratePassword;
import com.ecommerce.ecommerce.feature.auth.usecase.SignupUsecase;
import com.ecommerce.ecommerce.feature.vendor.Constant.VendorTypeEnum;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorBankDetail;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorSocialSetting;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorBankDetailsRepository;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorInfoRepository;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorSocialSettingRepository;
import com.ecommerce.ecommerce.feature.vendor.requestDto.OnboardVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.OnboardVendorResponseDto;
import com.ecommerce.ecommerce.feature.vendor.service.OnboardVendorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
    private final EmailService emailService;

    @Override
    public OnboardVendorResponseDto onboardVendor(OnboardVendorRequestDto vendorDetailsRequest) {
        String violations = ValidationUtils.validate(vendorDetailsRequest);
        if(!Objects.isNull(violations)) {
            throw new BadRequestException(violations);
        }

        if(vendorDetailsRequest.getMunicipality() == null && vendorDetailsRequest.getRuralMunicipality() == null ){
            throw new BadRequestException("Municipality or RuralMunicipality is required");
        }

        // Map the Dto to the entities
        VendorInfo vendorInfo = mapToVendorInfo(vendorDetailsRequest);

        vendorInfoRepository.save(vendorInfo);

        // VendorBankDetail
        VendorBankDetail bankDetail = vendorInfo.getVendorBankDetail();
        bankDetail.setVendorInfo(vendorInfo);
        vendorBankDetailsRepository.save(bankDetail);

        // VendorSocialSetting
        VendorSocialSetting socialSetting = vendorInfo.getVendorSocialSetting();
        socialSetting.setVendorInfo(vendorInfo);
        vendorSocialSettingRepository.save(socialSetting);

        String vendorPassword = GeneratePassword.generate(9);
        SignupUsecaseRequestDto signupRequestDto = getSignupUsecaseRequestDto(vendorDetailsRequest, vendorPassword);

        SignupResponse response = this.signupUsecase.register(signupRequestDto);

        if(response.getMessage().equals("Successfully Created user")){
//            this.emailService.sendHtmlEmail();
            System.out.println("Send the password to the email from here which is " + vendorPassword);
        }

        return new OnboardVendorResponseDto("Successfully Created Vendor");
    }

    private SignupUsecaseRequestDto getSignupUsecaseRequestDto(OnboardVendorRequestDto vendorDetailsRequest, String vendorPassword) {
        String userName;
        if(vendorDetailsRequest.getVendorUserName() != null && !vendorDetailsRequest.getVendorUserName().isEmpty()) {
            userName = vendorDetailsRequest.getVendorUserName();
        }else {
            userName = vendorDetailsRequest.getVendorFirstName() + " " + vendorDetailsRequest.getVendorLastName();
        }
        return new SignupUsecaseRequestDto(
                vendorDetailsRequest.getVendorFirstName(),
                vendorDetailsRequest.getVendorLastName(),
                vendorDetailsRequest.getVendorEmail(),
                vendorPassword,
                userName,
                vendorDetailsRequest.getContactNumber()
        );
    }

    public VendorInfo mapToVendorInfo(OnboardVendorRequestDto dto) {
        // Mapping logic...
        String vendorName = dto.getVendorFirstName() + " " + dto.getVendorLastName();

        // setting the vendor Info details;
        VendorInfo vendorInfo = new VendorInfo();
        vendorInfo.setVendorName(vendorName);
        vendorInfo.setEmail(dto.getVendorEmail());
        vendorInfo.setVendorBusinessName(dto.getVendorBusinessName());
        vendorInfo.setContactNo(dto.getContactNumber());
        vendorInfo.setSlug("abc");
        vendorInfo.setVendorType(VendorTypeEnum.fromDisplayName(dto.getVendorType()));
        vendorInfo.setStatus(StatusEnum.PENDING);
        vendorInfo.setImage("0232234-2323-2342323-234234"); // replace the hardcode value to dto.getImage();

        // setting the vendor bank details;
        VendorBankDetail vendorBankDetail = new VendorBankDetail();
        vendorBankDetail.setBankName(dto.getBankName());
        vendorBankDetail.setAccountHolder(dto.getAccountHolder());
        vendorBankDetail.setAccountNumber(dto.getAccountNumber());
        vendorBankDetail.setVendorInfo(vendorInfo);
        vendorInfo.setVendorBankDetail(vendorBankDetail);

        // setting the vendor social setting
        VendorSocialSetting vendorSocialSetting = new VendorSocialSetting();
        vendorSocialSetting.setFacebookUrl(dto.getFacebookUrl());
        vendorSocialSetting.setInstagramUrl(dto.getInstagramUrl());
        vendorSocialSetting.setTwitterUrl(dto.getTwitterUrl());
        vendorSocialSetting.setVendorInfo(vendorInfo);
        vendorInfo.setVendorSocialSetting(vendorSocialSetting);

        return vendorInfo;
    };
}
