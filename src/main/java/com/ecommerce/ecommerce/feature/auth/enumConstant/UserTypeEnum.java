package com.ecommerce.ecommerce.feature.auth.enumConstant;

public enum UserTypeEnum {
    MAKER("Maker"),
    VENDOR("Vendor"),
    CUSTOMER("Customer");

    private final String displayName;

    UserTypeEnum(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    // Static method to get the enum constant based on the display name
    public static UserTypeEnum fromDisplayName(String displayName) {
        for (UserTypeEnum userTypeEnum : UserTypeEnum.values()) {
            if (userTypeEnum.getDisplayName().equals(displayName)) {
                return userTypeEnum;
            }
        }
        throw new IllegalArgumentException("Unknown display name: " + displayName);
    }
}
