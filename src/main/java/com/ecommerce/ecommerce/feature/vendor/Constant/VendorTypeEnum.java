package com.ecommerce.ecommerce.feature.vendor.Constant;

public enum VendorTypeEnum {
    SERVICE_PROVIDER("Service Provider"),
    PRODUCT_SELLER("Product Seller"),
    PRODUCT_SERVICE_PROVIDER("Product+Service provider");

    private final String displayName;

    VendorTypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    // get the enum value from the display Name
    public static VendorTypeEnum fromDisplayName(String displayName) {
        for (VendorTypeEnum vendorTypeEnum : VendorTypeEnum.values()) {
            if (vendorTypeEnum.getDisplayName().equals(displayName)) {
                return vendorTypeEnum;
            }

        }
        throw new IllegalArgumentException("Vendor Type can have only Service Provider, Product Seller or Product+Service provider!");
    }
}
