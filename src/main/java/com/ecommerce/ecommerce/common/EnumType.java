package com.ecommerce.ecommerce.common;

import java.util.List;

public class EnumType {
    private String name;

    public EnumType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static <T extends  EnumType> List<T> getValues(Class<T> enumClass){
        throw new UnsupportedOperationException(enumClass.getSimpleName() + "getValues() not implemented");
    }

    public static <T extends EnumType> T getByName(Class<T> enumClass, String name){
        throw new UnsupportedOperationException(enumClass.getSimpleName() + " getByName() not implemented.");
    }
}
