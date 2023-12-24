package com.ecommerce.ecommerce.common;

public enum PricingEnum {
    PERCENT("Percentage"),
    FIXED("Fixed");

    private final String displayName;

    PricingEnum(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    public static PricingEnum fromDisplayName(String displayName){
        for(PricingEnum pricingEnum : PricingEnum.values()){
            if(pricingEnum.getDisplayName().equals(displayName)){
                return pricingEnum;
            }
        }
        throw new IllegalArgumentException("Unknow display name: " + displayName);
    }
}
