package com.ecommerce.ecommerce.common;

public enum StatusEnum {
    PENDING("Pending"),
    ACTIVE("Active"),
    DEACTIVE("Deactive");

    private final String displayName;

    StatusEnum(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    //Static method to get the enum constant based on the display name;
    public static StatusEnum fromDisplayName(String displayName){
        for(StatusEnum statusEnum : StatusEnum.values()){
            if(statusEnum.getDisplayName().equals(displayName)){
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("Unknow display name: " + displayName);
    }
}
