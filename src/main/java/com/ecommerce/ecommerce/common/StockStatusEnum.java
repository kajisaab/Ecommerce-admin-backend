package com.ecommerce.ecommerce.common;

public enum StockStatusEnum {

    AVAILABLE("Available"),
    OUT_OF_STOCK("Out of Stock");

    private final String displayName;

    StockStatusEnum(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    public static StockStatusEnum fromDisplayName(String displayName){
        for(StockStatusEnum stockStatusEnum : StockStatusEnum.values()){
            if(stockStatusEnum.getDisplayName().equals(displayName)){
                return stockStatusEnum;
            }
        }
        throw new IllegalArgumentException("Unknow display name : " + displayName);
    }
}
