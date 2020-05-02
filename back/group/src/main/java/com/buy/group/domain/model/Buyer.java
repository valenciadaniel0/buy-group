package com.buy.group.domain.model;

import java.math.BigDecimal;

public class Buyer{   
    private static final String ID_NUMBER_IS_REQUIRED = "Identification number is required";    
    
    private String address;
    private String idNumber;
    private BigDecimal rate;    
    private User user;

    public Buyer(String address, String idNumber,BigDecimal rate,User user) {        
        this.validateAttributes(idNumber);
        this.address = address;
        this.idNumber = idNumber;
        this.rate = rate;
        this.user = user;
    }

    public String getAddress(){
        return this.address;
    }

    public String getIdNumber(){
        return this.idNumber;
    }

    public BigDecimal getRate(){
        return this.rate;
    }

    public User getUser(){
        return this.user;
    }


    //Esto huele a picho
    private void validateAttributes(String idNumber){
        DataValidator.validateNull(idNumber, Buyer.ID_NUMBER_IS_REQUIRED);        
    }
    
}