package com.buy.group.domain.model;

import com.buy.group.domain.exception.GeneralException;

public final class DataValidator{
    public static void validateNull(String value,String message){
        if(value == null || value.isEmpty()){
            throw new GeneralException(message);
        }
    }
}