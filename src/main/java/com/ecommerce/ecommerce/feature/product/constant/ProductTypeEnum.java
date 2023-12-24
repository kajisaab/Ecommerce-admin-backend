package com.ecommerce.ecommerce.feature.product.constant;

public enum ProductTypeEnum {
    DIGITAL("Digital"),
    PHYSICAL("Physical");

    private final String displayName;

    ProductTypeEnum(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static ProductTypeEnum fromDisplayName(String displayName){
        for(ProductTypeEnum productTypeEnum: ProductTypeEnum.values()){
            if(productTypeEnum.getDisplayName().equals(displayName)){
                return productTypeEnum;
            }
        }
        throw new IllegalArgumentException("Unknown display name : " + displayName);
    }
}
